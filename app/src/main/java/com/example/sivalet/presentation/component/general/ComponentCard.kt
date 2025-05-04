package com.example.sivalet.presentation.component.general

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.sivalet.ui.theme.SiValetColor

@Composable
fun ComponentCard(
    title: String,
    height: Int,
    colorBackgroundTitle: Color = SiValetColor.White,
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(height.dp)
            .shadow(4.dp, shape = RoundedCornerShape(10.dp), clip = false)
            .clip(
                shape = RoundedCornerShape(10.dp)
            )
            .background(SiValetColor.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorBackgroundTitle)
        ) {
            TextBodyMediumBlack500(
                modifier = Modifier
                    .padding(horizontal = 15.dp, vertical = 13.dp),
                text = title
            )
        }

        Box {
            HorizontalDivider(
                modifier = Modifier.align(Alignment.BottomCenter),
                thickness = 1.dp,
                color = SiValetColor.Black.copy(alpha = 0.05f)
            )
        }

        content()
    }
}