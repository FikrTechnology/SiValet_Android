package com.example.sivalet.presentation.task

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sivalet.R
import com.example.sivalet.presentation.component.general.InformationStatusOngoing
import com.example.sivalet.presentation.component.general.TextBodyLargeWhite600
import com.example.sivalet.presentation.component.task.HeaderWithDropdown
import com.example.sivalet.ui.theme.SiValetColor
import com.example.sivalet.ui.theme.TaskStrings
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TaskScreen(
    onClickConfirm: () -> Unit = {}
){
    val akastra = LatLng(-6.2103535,106.7833774)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(akastra, 15f)
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
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            HeaderWithDropdown(
                selectedCar = selectedCar,
                onCarSelected = { selectedCar = it }
            )
            if (statusOnGoing) {
                InformationStatusOngoing()
            }
        }

    }
}