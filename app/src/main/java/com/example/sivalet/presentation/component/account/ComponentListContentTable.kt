package com.example.sivalet.presentation.component.account

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.example.sivalet.presentation.component.general.TextBodyMediumBlack500
import com.example.sivalet.ui.theme.SiValetColor

@Composable
fun ComponentListContentTable(
    icon: Painter,
    title: String,
) {
    Column {
        Row(
            modifier = Modifier
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                modifier = Modifier
                    .size(30.dp),
                painter = icon,
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(10.dp))
            TextBodyMediumBlack500(text = title)
        }
        Box {
            HorizontalDivider(
                modifier = Modifier.align(Alignment.BottomCenter),
                thickness = 1.dp,
                color = SiValetColor.Black.copy(alpha = 0.05f)
            )
        }
    }
}