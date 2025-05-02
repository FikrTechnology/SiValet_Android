package com.example.sivalet.presentation.component.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.sivalet.presentation.component.general.CardTag
import com.example.sivalet.presentation.component.general.TextBodyMediumBlack500
import com.example.sivalet.ui.theme.SiValetColor

@Composable
fun LazyColumnToDoList(
    onClickToDoList : () -> Unit
){
    LazyColumn(
        modifier = Modifier
            .padding(horizontal = 16.5.dp, vertical = 9.dp),
        verticalArrangement = Arrangement.spacedBy(9.dp),
    ) {
        // Add a single item
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        shape = RoundedCornerShape(4.dp)
                    )
                    .background(SiValetColor.SmoothWhite)
                    .clickable { onClickToDoList() }
                    .padding(horizontal = 17.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row {
                    TextBodyMediumBlack500(text = "RAIZE")
                    Spacer(modifier = Modifier.width(5.dp))
                    TextBodyMediumBlack500(text = "B55SKU")
                }
                CardTag(
                    text = "Pickup",
                    backgroundColor = SiValetColor.Third
                )
            }
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        shape = RoundedCornerShape(4.dp)
                    )
                    .background(SiValetColor.SmoothWhite)
                    .padding(horizontal = 17.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row {
                    TextBodyMediumBlack500(text = "AGYA")
                    Spacer(modifier = Modifier.width(5.dp))
                    TextBodyMediumBlack500(text = "B55SKU")
                }
                CardTag(
                    text = "Delivery",
                    backgroundColor = SiValetColor.Secondary,
                    textColorBlack = false
                )
            }
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        shape = RoundedCornerShape(4.dp)
                    )
                    .background(SiValetColor.SmoothWhite)
                    .padding(horizontal = 17.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row {
                    TextBodyMediumBlack500(text = "RAIZE")
                    Spacer(modifier = Modifier.width(5.dp))
                    TextBodyMediumBlack500(text = "B55SKU")
                }
                CardTag(
                    text = "Pickup",
                    backgroundColor = SiValetColor.Third,
                )
            }
        }
    }
}