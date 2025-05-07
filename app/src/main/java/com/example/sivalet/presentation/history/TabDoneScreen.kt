package com.example.sivalet.presentation.history

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sivalet.presentation.component.history.ComponentTaskCardHistory
import com.example.sivalet.ui.theme.SiValetColor

@Composable
fun DoneContent() {
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