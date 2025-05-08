package com.example.sivalet.presentation.component.general

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.sivalet.ui.theme.Roboto
import com.example.sivalet.ui.theme.SiValetColor


//////////////////////////////// TEXT Title Style //////////////////////////////////
@Composable
fun TextTitleMedium(
    text: String,
    color: Color = Color.Unspecified,
    fontWeight: FontWeight = FontWeight.W400,
){
    Text(
        text = text,
        style = MaterialTheme.typography.titleMedium,
        color = color,
        fontWeight = fontWeight
    )
}

@Composable
fun TextTitleMediumBlack600(
    text: String,
){
    Text(
        text = text,
        style = MaterialTheme.typography.titleMedium,
        color = SiValetColor.Black,
        fontWeight = FontWeight.W600
    )
}



//////////////////////////////// TEXT Body Style //////////////////////////////////
@Composable
fun TextBodyLarge600(
    modifier: Modifier,
    text: String,
    color: Color = Color.Unspecified
){
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.bodyLarge,
        color = color,
        fontWeight = FontWeight.W600
    )
}

@Composable
fun TextBodyLargeWhite600(
    text: String,
){
    Text(
        text = text,
        style = MaterialTheme.typography.bodyLarge,
        color = SiValetColor.White,
        fontWeight = FontWeight.W600
    )
}

@Composable
fun TextBodyLargePrimary600(
    text: String,
){
    Text(
        text = text,
        style = MaterialTheme.typography.bodyLarge,
        color = SiValetColor.Primary,
        fontWeight = FontWeight.W600
    )
}

@Composable
fun TextBodyLargeBlack500(
    text: String,
){
    Text(
        text = text,
        style = MaterialTheme.typography.bodyLarge,
        color = SiValetColor.Black,
        fontWeight = FontWeight.W500
    )
}

@Composable
fun TextBodySemiLargeBlack500(
    text: String,
){
    Text(
        text = text,
        fontFamily = Roboto,
        fontSize = 14.sp,
        color = SiValetColor.Black,
        fontWeight = FontWeight.W500
    )
}

@Composable
fun TextBodySemiLargeWhite500(
    text: String,
){
    Text(
        text = text,
        fontFamily = Roboto,
        fontSize = 14.sp,
        color = SiValetColor.White,
        fontWeight = FontWeight.W500
    )
}

@Composable
fun TextBodySemiLargeGray400(
    text: String,
){
    Text(
        text = text,
        fontFamily = Roboto,
        fontSize = 14.sp,
        color = SiValetColor.Black.copy(alpha = 0.7f),
        fontWeight = FontWeight.W400
    )
}

@Composable
fun TextBodyMedium(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = Color.Unspecified,
    fontWeight: FontWeight = FontWeight.W400
){
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        color = color,
        fontWeight = fontWeight
    )
}

@Composable
fun TextBodyMediumBlack500(
    modifier: Modifier = Modifier,
    text: String,
){
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        color = SiValetColor.Black,
        fontWeight = FontWeight.W500
    )
}

@Composable
fun TextBodyMediumWhite500(
    modifier: Modifier = Modifier,
    text: String,
){
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        color = SiValetColor.White,
        fontWeight = FontWeight.W500
    )
}

@Composable
fun TextBodyMediumGray400(
    text: String,
    fontWeight: FontWeight? = FontWeight.W400
){
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        color = SiValetColor.Black.copy(alpha = 0.55f),
        fontWeight = fontWeight
    )
}

@Composable
fun TextBodySmallOldBlue500(
    text: String,
){
    Text(
        text = text,
        style = MaterialTheme.typography.bodySmall,
        color = SiValetColor.OldBlue,
        fontWeight = FontWeight.W500
    )
}

@Composable
fun TextBodySmallGray400(
    text: String,
){
    Text(
        text = text,
        style = MaterialTheme.typography.bodySmall,
        color = SiValetColor.Black.copy(alpha = 0.7f),
        fontWeight = FontWeight.W400
    )
}

@Composable
fun TextBodySmall12sp500(
    text: String,
){
    Text(
        text = text,
        style = MaterialTheme.typography.bodySmall,
        color = SiValetColor.Black,
        fontSize = 12.sp,
        fontWeight = FontWeight.W500
    )
}