package com.example.sivalet.presentation.component.history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.sivalet.presentation.component.general.TextBodyMediumGray400

@Composable
fun ComponentDateTimeHistory(
    icon: Painter,
    text: String
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(7.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = icon,
            contentDescription = null
        )
        TextBodyMediumGray400(
            text = text,
            fontWeight = FontWeight.W500
        )
    }
}