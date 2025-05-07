package com.example.sivalet.presentation.history

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sivalet.presentation.component.history.ComponentTaskCardHistory
import com.example.sivalet.ui.theme.SiValetColor

@Composable
fun ProcessContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 18.dp, horizontal = 2.dp)
            .background(SiValetColor.White),
        verticalArrangement = Arrangement.spacedBy(13.dp)
    ) {
        ComponentTaskCardHistory(
            isCardDelivery = false,
            carNumber = "RAIZE B55SKU",
            driverName = "Zainudin",
            date = "2024/03/03 09:00",
            time = "50 menit"
        )

        ComponentTaskCardHistory(
            carNumber = "RAIZE B55SKU",
            driverName = "Zainudin",
            date = "2024/03/03 09:00",
            time = "50 menit"
        )
    }
}