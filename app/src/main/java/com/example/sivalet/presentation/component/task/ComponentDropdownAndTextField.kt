package com.example.sivalet.presentation.component.task

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sivalet.R
import com.example.sivalet.presentation.component.general.CardTag
import com.example.sivalet.presentation.component.general.TextBodyMediumGray400
import com.example.sivalet.ui.theme.CoordinatorTaskStrings
import com.example.sivalet.ui.theme.SiValetColor

@Composable
fun ComponentButtonDropdown(
    isPlaceHolderText: Boolean = true,
    icon: Painter,
    placeholderText: String,
    onClick: () -> Unit = {}
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(SiValetColor.White)
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 13.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                modifier = Modifier.width(15.dp),
                painter = icon,
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(10.dp))
            if (isPlaceHolderText) {
                TextBodyMediumGray400(
                    text = placeholderText
                )
            } else {
                CardTag(
                    text = placeholderText,
                    backgroundColor = SiValetColor.Third
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = null
            )
        }
        Box {
            HorizontalDivider(
                modifier = Modifier.align(Alignment.BottomCenter),
                thickness = 1.dp,
                color = SiValetColor.Gray
            )
        }
    }
}


@Composable
fun ComponentCoordinatorTextField(
    icon: Painter,
    placeholderText: String,
    textField: String,
    onValueChange: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(SiValetColor.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 13.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                modifier = Modifier.width(15.dp),
                painter = icon,
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(10.dp))
            Box {
                BasicTextField(
                    value = textField,
                    onValueChange = onValueChange,
                    textStyle = MaterialTheme.typography.bodyMedium.copy(
                        color = SiValetColor.Black,
                        fontWeight = FontWeight.W500,
                        fontSize = 13.33.sp
                    ),
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                )

                if (textField.isEmpty()) {
                    TextBodyMediumGray400(text = placeholderText)
                }
            }
        }
        Box {
            HorizontalDivider(
                modifier = Modifier.align(Alignment.BottomCenter),
                thickness = 1.dp,
                color = SiValetColor.Gray
            )
        }
    }
}