package com.example.sivalet.presentation.component.task

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.sivalet.R
import com.example.sivalet.presentation.component.general.TextBodyLargeBlack500
import com.example.sivalet.presentation.component.general.TextBodyMediumGray400
import com.example.sivalet.presentation.component.general.TextBodySmallGray400
import com.example.sivalet.ui.theme.SiValetColor

@Composable
fun HeaderConfirmationTask(
    name: String,
    os: String,
    date: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(SiValetColor.BorderColor)
            .padding(horizontal = 26.dp, vertical = 36.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .width(73.dp)
                .height(73.dp),
            painter = painterResource(id = R.drawable.img_profile),
            contentDescription = "Image Profile"
        )
        Spacer(modifier = Modifier.width(43.dp))
        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            TextBodyLargeBlack500(text = name)
            TextBodyMediumGray400(text = os)
            TextBodySmallGray400(text = date)
        }
    }
}