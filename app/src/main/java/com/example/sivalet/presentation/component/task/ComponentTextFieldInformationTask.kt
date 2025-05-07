package com.example.sivalet.presentation.component.task

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sivalet.presentation.component.general.TextBodyMediumBlack500
import com.example.sivalet.ui.theme.SiValetColor

@Composable
fun ComponentTextFieldInformationTask(
    isImageVector: Boolean = true,
    imageVector: ImageVector? = null,
    painter: Painter? = null,
    textTitle: String,
    textField: String,
    onValueChange: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp)
            .clip(
                shape = RoundedCornerShape(4.dp)
            )
            .border(
                width = 1.dp,
                color = SiValetColor.BorderColor,
                shape = RoundedCornerShape(4.dp)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .weight(0.4f)
                .background(SiValetColor.BorderColor)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 13.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                if (isImageVector) {
                    imageVector?.let {
                        Icon(
                            imageVector = it,
                            contentDescription = null,
                        )
                    }
                } else {
                    painter?.let {
                        Icon(
                            painter = it,
                            contentDescription = null,
                        )
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))
                TextBodyMediumBlack500(text = textTitle)
            }
        }

        Box(
            modifier = Modifier
                .weight(0.6f)
        ) {
            BasicTextField(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 10.dp, vertical = 11.dp),
                value = textField,
                onValueChange = onValueChange,
                textStyle = MaterialTheme.typography.bodyMedium.copy(
                    color = SiValetColor.Black,
                    fontWeight = FontWeight.W500,
                    fontSize = 13.33.sp
                ),
                singleLine = true
            )
        }
    }
}