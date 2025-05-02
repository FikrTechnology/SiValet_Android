package com.example.sivalet.presentation.component.task

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sivalet.R
import com.example.sivalet.presentation.component.general.CardTag
import com.example.sivalet.presentation.component.general.TextBodyLargeBlack500
import com.example.sivalet.presentation.component.general.TextBodyMediumBlack500
import com.example.sivalet.presentation.component.general.TextBodySemiLargeGray400
import com.example.sivalet.ui.theme.SiValetColor
import com.example.sivalet.ui.theme.TaskStrings

@Composable
fun HeaderWithDropdown(
    selectedCar: String,
    onCarSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    val carList = listOf("RAIZE B55SKU", "AVANZA D88NJK", "INNOVA Z99KLM")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.White)
            .padding(horizontal = 14.dp, vertical = 21.dp)
    ) {
        // Dropdown Mobil
        Column(
            modifier = Modifier
                .clickable {
                    expanded = !expanded
                }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "Down Arrow",
                )
                TextBodyMediumBlack500(text = "RAIZE")
                Spacer(modifier = Modifier.width(6.dp))
                TextBodyMediumBlack500(text = "B55SKU")
                Spacer(modifier = Modifier.width(10.dp))
                CardTag(
                    text = TaskStrings.LABEL_DELIVERY,
                    backgroundColor = SiValetColor.Purple,
                    textColorBlack = false
                )
            }

            AnimatedVisibility(expanded) {
                Column {
                    carList.forEach { car ->
                        DropdownMenuItem(
                            text = { Text(car) },
                            onClick = {
                                onCarSelected(car)
                                expanded = false
                            }
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(19.dp))

        // Lokasi
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(14.dp),
                    painter = painterResource(id = R.drawable.ico_current_location),
                    contentDescription = "Location Icon",
                )
                Spacer(modifier = Modifier.width(8.dp))
                TextBodyLargeBlack500(text = TaskStrings.LABEL_CURRENT_LOC)
            }

            Spacer(modifier = Modifier.height(4.dp))

            TextBodySemiLargeGray400(text = "Jalan Raya Kebayoran Lama No.26, Palmerah, VII, RT.1/RW.2, North Sukabumi, Kebonjeruk, West Jakarta City, Jakarta 11540")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CheckHeader(){
    HeaderWithDropdown(selectedCar = "RAIZE B55SKU") {}
}