package com.example.sivalet.presentation.task

import android.Manifest
import android.content.pm.PackageManager
import android.location.Geocoder
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.example.sivalet.R
import com.example.sivalet.presentation.component.general.InformationStatusOngoing
import com.example.sivalet.presentation.component.general.TextBodyLargeWhite600
import com.example.sivalet.presentation.component.task.HeaderWithDropdown
import com.example.sivalet.ui.theme.SiValetColor
import com.example.sivalet.ui.theme.TaskStrings
import com.example.sivalet.utils.getUserLocation
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import java.io.IOException
import java.util.Locale

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TaskScreen(
    onClickConfirm: () -> Unit = {}
){
    val context = LocalContext.current
    val fusedLocationProviderClient = remember {
        LocationServices.getFusedLocationProviderClient(context)
    }
    var addressText by remember { mutableStateOf<String?>(null) }

    var userLocation by remember { mutableStateOf<LatLng?>(null) }
    val cameraPositionState = rememberCameraPositionState()

    // Permission launcher
    val locationPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            if (isGranted) {
                getUserLocation(fusedLocationProviderClient) { location ->
                    location?.let {
                        userLocation = LatLng(it.latitude, it.longitude)
                    }
                }
            }
        }
    )

    // Check and request permission
    LaunchedEffect(Unit) {
        if (ContextCompat.checkSelfPermission(
                context, Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            getUserLocation(fusedLocationProviderClient) { location ->
                location?.let {
                    userLocation = LatLng(it.latitude, it.longitude)
                }
            }
        } else {
            locationPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    // Move camera when userLocation is ready
    LaunchedEffect(userLocation) {
        userLocation?.let {
            cameraPositionState.move(CameraUpdateFactory.newLatLngZoom(it, 16f))

            // Reverse geocoding
            val geocoder = Geocoder(context, Locale.getDefault())
            try {
                val addresses = geocoder.getFromLocation(it.latitude, it.longitude, 1)
                if (!addresses.isNullOrEmpty()) {
                    val address = addresses[0]
                    // Contoh: Nama tempat atau alamat lengkap
                    addressText = address.getAddressLine(0) // Alamat lengkap
                    // Bisa juga: address.locality (kota), address.subAdminArea, dst.
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    var statusOnGoing by remember { mutableStateOf(false) }
    var selectedCar by rememberSaveable { mutableStateOf("RAIZE B55SKU") }

    fun validateStatus(){
        if (statusOnGoing) {
            statusOnGoing = false
            println("Clock Out")
        } else {
            onClickConfirm()
        }
    }

    Scaffold(
        contentWindowInsets = WindowInsets(0.dp),

        floatingActionButton = {
            ExtendedFloatingActionButton(
                modifier = Modifier.padding(bottom = 70.dp),
                text = {
                    if (statusOnGoing) TextBodyLargeWhite600(text = TaskStrings.LABEL_CLOCK_OUT)
                    else TextBodyLargeWhite600(text = TaskStrings.LABEL_CLOCK_IN)
                },
                icon = {
                    Icon(
                        painter = if (statusOnGoing) painterResource(id = R.drawable.ico_stop_rectangle) else painterResource(
                            id = R.drawable.ico_play_arrow
                        ),
                        contentDescription = "Play & Stop status",
                        tint = SiValetColor.White
                    )
                },
                onClick = { validateStatus() },
                containerColor = if (statusOnGoing) SiValetColor.Red else SiValetColor.Secondary,
                shape = CircleShape
            )
        }
    ) {paddingValues ->
        GoogleMap(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            cameraPositionState = cameraPositionState
        ) {
            userLocation?.let {
                Marker(
                    state = MarkerState(position = it),
                    title = "Current Location"
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            HeaderWithDropdown(
                selectedCar = selectedCar,
                onCarSelected = { selectedCar = it },
                locationName = addressText.orEmpty(),
            )
            if (statusOnGoing) {
                InformationStatusOngoing()
            }
        }

    }
}