package com.example.sivalet.presentation.task

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun TaskScreen(){
    Scaffold(
        contentWindowInsets = WindowInsets(0.dp),
    ) {paddingValues ->
        val akastra = LatLng(-6.2103535,106.7833774)
        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(akastra, 15f)
        }

        GoogleMap(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            cameraPositionState = cameraPositionState
        )
    }
}