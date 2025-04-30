package com.example.sivalet.presentation.component.login

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.sivalet.presentation.component.general.TextBodyMediumBlack500
import com.example.sivalet.presentation.component.general.TextBodyMediumGray400
import com.example.sivalet.ui.theme.Roboto
import com.example.sivalet.ui.theme.SiValetColor

@Composable
fun OutlinedTextFieldLogin(
    labelName: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    trailingIcon: @Composable (() -> Unit)? = null,
    keyboardType: KeyboardType = KeyboardType.Unspecified,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    TextBodyMediumBlack500(
        text = labelName
    )
    Spacer(modifier = Modifier.height(10.dp))
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(51.dp),
        value = value,
        onValueChange = onValueChange,
        placeholder = { TextBodyMediumGray400(text = placeholder) },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = SiValetColor.BorderColor,
            unfocusedPlaceholderColor = SiValetColor.Black.copy(alpha = 0.5f),
            focusedBorderColor = SiValetColor.Primary
        ),
        shape = RoundedCornerShape(4.dp),
        trailingIcon = trailingIcon,
        singleLine = true,
        textStyle = TextStyle(
            fontFamily = Roboto,
            color = SiValetColor.Black,
            fontWeight = FontWeight.W500
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        ),
        visualTransformation = visualTransformation
    )
}