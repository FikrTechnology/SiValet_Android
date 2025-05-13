package com.example.sivalet.presentation.component.general

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun ComponentButton(
    onClick: () -> Unit = {},
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    isWithIcon: Boolean = false,
    isTextColorWhite: Boolean = true,
    painter: Painter? = null,
    tint: Color = LocalContentColor.current,
    labelButton: String = "Button",
    enabled: Boolean = true
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(47.dp),
        onClick = onClick,
        colors = colors
    ) {
        if (isWithIcon) {
            painter?.let {
                Icon(
                    painter = it,
                    contentDescription = null,
                    tint = tint
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
        }

        if (isTextColorWhite) {
            TextBodyLargeWhite600(text = labelButton)
        } else {
            TextBodyLargePrimary600(text = labelButton)
        }
    }
}