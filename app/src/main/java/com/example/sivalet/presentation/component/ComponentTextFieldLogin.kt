package com.example.sivalet.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.sivalet.R
import com.example.sivalet.ui.theme.SiValetColor

@Composable
fun OutlinedTextFieldLogin(
    labelName: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    TextBodyMediumBlack500(
        text = labelName
    )
    Spacer(modifier = Modifier.height(10.dp))
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        placeholder = { TextBodyMediumGray400(text = placeholder) },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = SiValetColor.BorderColor,
            unfocusedPlaceholderColor = SiValetColor.Black.copy(alpha = 0.5f),
        ),
        shape = RoundedCornerShape(4.dp),
        trailingIcon = trailingIcon
    )
//    BasicTextField(
//        value = value,
//        onValueChange = onValueChange,
//        singleLine = true,
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(44.dp)
//            .background(Color.White, RoundedCornerShape(4.dp))
//            .border(
//                width = 1.dp,
//                color = SiValetColor.BorderColor,
//                shape = RoundedCornerShape(4.dp)
//            )
//            .padding(horizontal = 12.dp), // padding manual
//        decorationBox = { innerTextField ->
//            Box(
//                Modifier
//                    .fillMaxSize(),
//                contentAlignment = Alignment.CenterStart
//            ) {
//                if (value.isEmpty()) {
//                    Text(
//                        text = placeholder,
//                        color = SiValetColor.Black.copy(alpha = 0.5f),
//                        style = MaterialTheme.typography.bodyMedium
//                    )
//                }
//                innerTextField()
//            }
//        }
//    )
}