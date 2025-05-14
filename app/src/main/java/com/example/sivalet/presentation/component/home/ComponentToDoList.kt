package com.example.sivalet.presentation.component.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.sivalet.R
import com.example.sivalet.presentation.component.general.CardTag
import com.example.sivalet.presentation.component.general.TextBodyMedium
import com.example.sivalet.presentation.component.general.TextBodyMediumBlack500
import com.example.sivalet.ui.theme.HomeStrings
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


@Composable
fun LazyColumnDriverList() {
    var expanded by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = Modifier
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        item {
            Column(
                modifier = Modifier
                    .clickable {
                        expanded = !expanded
                    }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = if (expanded) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowRight,
                        contentDescription = "Down Arrow",
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    TextBodyMediumBlack500(text = "Thomas")
                    Spacer(modifier = Modifier.weight(1f))
                    CardTag(
                        text = HomeStrings.LABEL_STAND_BY,
                        backgroundColor = SiValetColor.BorderColor,
                        paddingHorizontal = 10,
                        paddingVertical = 8
                    )
                }

                AnimatedVisibility(
                    modifier = Modifier
                        .padding(0.dp)
                        .background(SiValetColor.SmoothWhite),
                    visible = expanded
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 17.dp, vertical = 7.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp, horizontal = 10.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ico_whatsapp),
                                    contentDescription = null,
                                    tint = SiValetColor.Primary
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                TextBodyMedium(
                                    text = HomeStrings.LABEL_WHATSAPP,
                                    color = SiValetColor.Primary
                                )
                            }
                            HorizontalDivider(
                                color = SiValetColor.Gray
                            )
                        }

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp, horizontal = 10.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ico_car_key),
                                    contentDescription = null,
                                    tint = SiValetColor.Black
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                TextBodyMedium(
                                    text = "RAIZE - B66AKU",
                                    color = SiValetColor.Black
                                )
                            }
                            HorizontalDivider(
                                color = SiValetColor.Gray
                            )
                        }

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp, horizontal = 10.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ico_user),
                                    contentDescription = null,
                                    tint = SiValetColor.Black
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                TextBodyMedium(
                                    text = "NURITA",
                                    color = SiValetColor.Black
                                )
                            }
                            HorizontalDivider(
                                color = SiValetColor.Gray
                            )
                        }
                    }
                }
            }
        }

        item {
            Column(
                modifier = Modifier
                    .clickable {
                        expanded = !expanded
                    }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = if (expanded) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowRight,
                        contentDescription = "Down Arrow",
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    TextBodyMediumBlack500(text = "Ferdi")
                    Spacer(modifier = Modifier.weight(1f))
                    CardTag(
                        text = HomeStrings.LABLE_PICKUP,
                        backgroundColor = SiValetColor.Third,
                        paddingHorizontal = 10,
                        paddingVertical = 8
                    )
                }

                AnimatedVisibility(
                    modifier = Modifier
                        .padding(0.dp)
                        .background(SiValetColor.SmoothWhite),
                    visible = expanded
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 17.dp, vertical = 7.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp, horizontal = 10.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ico_whatsapp),
                                    contentDescription = null,
                                    tint = SiValetColor.Primary
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                TextBodyMedium(
                                    text = HomeStrings.LABEL_WHATSAPP,
                                    color = SiValetColor.Primary
                                )
                            }
                            HorizontalDivider(
                                color = SiValetColor.Gray
                            )
                        }

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp, horizontal = 10.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ico_car_key),
                                    contentDescription = null,
                                    tint = SiValetColor.Black
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                TextBodyMedium(
                                    text = "RAIZE - B66AKU",
                                    color = SiValetColor.Black
                                )
                            }
                            HorizontalDivider(
                                color = SiValetColor.Gray
                            )
                        }

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp, horizontal = 10.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ico_user),
                                    contentDescription = null,
                                    tint = SiValetColor.Black
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                TextBodyMedium(
                                    text = "NURITA",
                                    color = SiValetColor.Black
                                )
                            }
                            HorizontalDivider(
                                color = SiValetColor.Gray
                            )
                        }
                    }
                }
            }
        }

        item {
            Column(
                modifier = Modifier
                    .clickable {
                        expanded = !expanded
                    }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = if (expanded) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowRight,
                        contentDescription = "Down Arrow",
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    TextBodyMediumBlack500(text = "Bayu")
                    Spacer(modifier = Modifier.weight(1f))
                    CardTag(
                        text = HomeStrings.LABEL_DELIVERY,
                        backgroundColor = SiValetColor.Secondary,
                        textColorBlack = false,
                        paddingHorizontal = 10,
                        paddingVertical = 8
                    )
                }

                AnimatedVisibility(
                    modifier = Modifier
                        .padding(0.dp)
                        .background(SiValetColor.SmoothWhite),
                    visible = expanded
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 17.dp, vertical = 7.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp, horizontal = 10.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ico_whatsapp),
                                    contentDescription = null,
                                    tint = SiValetColor.Primary
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                TextBodyMedium(
                                    text = HomeStrings.LABEL_WHATSAPP,
                                    color = SiValetColor.Primary
                                )
                            }
                            HorizontalDivider(
                                color = SiValetColor.Gray
                            )
                        }

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp, horizontal = 10.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ico_car_key),
                                    contentDescription = null,
                                    tint = SiValetColor.Black
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                TextBodyMedium(
                                    text = "RAIZE - B66AKU",
                                    color = SiValetColor.Black
                                )
                            }
                            HorizontalDivider(
                                color = SiValetColor.Gray
                            )
                        }

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp, horizontal = 10.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ico_user),
                                    contentDescription = null,
                                    tint = SiValetColor.Black
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                TextBodyMedium(
                                    text = "NURITA",
                                    color = SiValetColor.Black
                                )
                            }
                            HorizontalDivider(
                                color = SiValetColor.Gray
                            )
                        }
                    }
                }
            }
        }
    }
}