package com.example.sivalet.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sivalet.ui.theme.HomeStrings
import com.example.sivalet.ui.theme.SiValetColor

@Composable
fun PieChartSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.5.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(137.dp),
            contentAlignment = Alignment.Center
        ) {
            TaskDonutChart(
                pickupPercentage = 0.6f,
                deliveryPercentage = 0.4f
            )
        }

        TextBodySmall12sp500(text = HomeStrings.LABEL_LAST_30_DAYS)

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .background(SiValetColor.Third, shape = RoundedCornerShape(5.dp))
            )
            Spacer(modifier = Modifier.width(6.dp))
            TextBodySmall12sp500(text = HomeStrings.LABLE_PICKUP)

            Spacer(modifier = Modifier.width(12.dp))

            Box(
                modifier = Modifier
                    .size(12.dp)
                    .background(SiValetColor.Secondary, shape = RoundedCornerShape(5.dp))
            )
            Spacer(modifier = Modifier.width(6.dp))
            TextBodySmall12sp500(text = HomeStrings.LABEL_DELIVERY)
        }


    }
}