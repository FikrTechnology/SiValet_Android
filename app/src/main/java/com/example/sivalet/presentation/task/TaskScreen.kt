package com.example.sivalet.presentation.task

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sivalet.presentation.component.task.HeaderWithDropdown
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TaskScreen(){
    val akastra = LatLng(-6.2103535,106.7833774)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(akastra, 15f)
    }

    var selectedCar by rememberSaveable { mutableStateOf("RAIZE B55SKU") }

    Scaffold(
        contentWindowInsets = WindowInsets(0.dp),


    ) {paddingValues ->
        GoogleMap(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            cameraPositionState = cameraPositionState
        )

        HeaderWithDropdown(
            selectedCar = selectedCar,
            onCarSelected = { selectedCar = it }
        )


    }
}