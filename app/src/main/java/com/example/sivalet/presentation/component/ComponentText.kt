package com.example.sivalet.presentation.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.example.sivalet.ui.theme.Roboto
import com.example.sivalet.ui.theme.SiValetColor

//////////////////////////////// TEXT Headline Styles //////////////////////////////////
@Composable
fun TextHeadline1(
    text: String
){
    Text(
        text = text,
        style = MaterialTheme.typography.headlineLarge,
        color = SiValetColor.Black,
        fontWeight = FontWeight.W600,
    )
}

@Composable
fun TextHeadline2(
    text: String
){
    Text(
        text = text,
        color = SiValetColor.Black,
        fontSize = 24.sp,
        fontWeight = FontWeight.W700,
    )
}

@Composable
fun TextHeadline3(
    text: String
){
    Text(
        text = text,
        color = SiValetColor.Black,
        fontSize = 18.sp,
        fontWeight = FontWeight.W700,
    )
}


//////////////////////////////// TEXT Title Style //////////////////////////////////
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
){
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        color = SiValetColor.Black.copy(alpha = 0.55f),
        fontWeight = FontWeight.W400
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


////////////////////////////////// TEXT Label Style //////////////////////////////////
@Composable
fun TextLabel1Bold(
    text: String,
    color: Color = Color.Unspecified
){
    Text(
        text = text,
        color = color,
        fontSize = 14.sp,
        fontWeight = FontWeight.W600,
    )
}

@Composable
fun TextLabel2Reguler(
    text: String,
    color: Color = Color.Unspecified
){
    Text(
        text = text,
        color = color,
        fontSize = 12.sp,
        fontWeight = FontWeight.W400,
    )
}


////////////////////////////////// TEXT Underline Style //////////////////////////////////
@Composable
fun TextUnderline2Bold(
    text: String,
    color: Color = Color.Unspecified
){
    Text(
        text = text,
        color = color,
        textDecoration = TextDecoration.Underline,
        fontSize = 14.sp,
        fontWeight = FontWeight.W700
    )
}