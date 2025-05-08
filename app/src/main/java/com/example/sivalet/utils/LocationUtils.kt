package com.example.sivalet.utils

import android.annotation.SuppressLint
import android.location.Location

@SuppressLint("MissingPermission")
fun getUserLocation(
    fusedLocationProviderClient: com.google.android.gms.location.FusedLocationProviderClient,
    onLocationRetrieved: (Location?) -> Unit
) {
    fusedLocationProviderClient.lastLocation
        .addOnSuccessListener { location ->
            onLocationRetrieved(location)
        }
        .addOnFailureListener {
            onLocationRetrieved(null)
        }
}