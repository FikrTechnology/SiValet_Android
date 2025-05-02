package com.example.sivalet.presentation.component.general

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CardTag(
    text: String,
    backgroundColor: Color = Color.Unspecified,
    textColorBlack: Boolean = true
) {
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(2.dp))
            .background(backgroundColor)
            .padding(horizontal = 8.dp, vertical = 2.dp)
    ) {
        if (textColorBlack) {
            TextBodyMediumBlack500(text = text)
        } else {
            TextBodyMediumWhite500(text = text)
        }
    }
}