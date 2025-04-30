package com.example.sivalet.presentation.component.home

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.example.sivalet.presentation.component.general.TextBodyMediumBlack500
import com.example.sivalet.ui.theme.HomeStrings
import com.example.sivalet.ui.theme.SiValetColor

@Composable
fun TaskDonutChart(
    modifier: Modifier = Modifier,
    pickupPercentage: Float,
    deliveryPercentage: Float
) {
    val totalAngle = 360f
    val pickupAngle = totalAngle * pickupPercentage
    val deliveryAngle = totalAngle * deliveryPercentage

    Box(
        modifier = modifier
            .size(110.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val strokeWidth = size.width / 4
            drawArc(
                color = SiValetColor.Third, // Kuning
                startAngle = -90f,
                sweepAngle = pickupAngle,
                useCenter = false,
                style = Stroke(strokeWidth, cap = StrokeCap.Butt)
            )
            drawArc(
                color = SiValetColor.Secondary, // Hijau
                startAngle = -90f + pickupAngle,
                sweepAngle = deliveryAngle,
                useCenter = false,
                style = Stroke(strokeWidth, cap = StrokeCap.Butt)
            )
        }

        TextBodyMediumBlack500(text = HomeStrings.LABEL_TASK)
    }
}