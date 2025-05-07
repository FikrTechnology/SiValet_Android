package com.example.sivalet.presentation.component.history

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.sivalet.R
import com.example.sivalet.presentation.component.general.CardTag
import com.example.sivalet.presentation.component.general.TextBodyMediumBlack500
import com.example.sivalet.presentation.component.general.TextTitleMedium
import com.example.sivalet.ui.theme.HistoryStrings
import com.example.sivalet.ui.theme.SiValetColor

@Composable
fun ComponentTaskCardHistory(
    isCardDelivery: Boolean = true,
    carNumber: String,
    isDriver: Boolean = true,
    driverName: String,
    date: String,
    time: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .shadow(
                2.dp,
                shape = RoundedCornerShape(10.dp),
                clip = true
            )
            .clip(RoundedCornerShape(10.dp))
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        SiValetColor.White,
                        if (isCardDelivery) SiValetColor.Bubbles else SiValetColor.Ivory
                    )
                )
            ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 21.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            CardTag(
                text = if (isCardDelivery) HistoryStrings.LABEL_DELIVERY else HistoryStrings.LABEL_PICKUP,
                backgroundColor = if (isCardDelivery) SiValetColor.Secondary else SiValetColor.Third,
                textColorBlack = !isCardDelivery,
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextTitleMedium(
                    text = carNumber,
                    color = SiValetColor.Black,
                    fontWeight = FontWeight.W700
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = if (isDriver) painterResource(id = R.drawable.img_profile) else painterResource(id = R.drawable.img_profile_cordinator),
                        contentDescription = null
                    )
                    TextBodyMediumBlack500(text = driverName)
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                ComponentDateTimeHistory(
                    icon = painterResource(id = R.drawable.ico_date_gray),
                    text = date
                )
                ComponentDateTimeHistory(
                    icon = painterResource(id = R.drawable.ico_time_gray),
                    text = time
                )
            }
        }
    }
}