package com.example.sivalet.presentation.task

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sivalet.R
import com.example.sivalet.presentation.component.general.ComponentButton
import com.example.sivalet.presentation.component.general.TextBodyLargeBlack500
import com.example.sivalet.presentation.component.general.TextBodyMedium
import com.example.sivalet.presentation.component.task.ComponentButtonDropdown
import com.example.sivalet.presentation.component.task.ComponentCoordinatorTextField
import com.example.sivalet.ui.theme.CoordinatorTaskStrings
import com.example.sivalet.ui.theme.SiValetColor
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun TaskCoordinatorScreen(
    onClickBack: () -> Unit = {},
    onClickAddTask: () -> Unit = {}
) {
    var date by remember { mutableStateOf("") }
    var policeNumber by remember { mutableStateOf("") }
    var customerName by remember { mutableStateOf("") }
    var taskDesc by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }

    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }

    var estimationTime by remember { mutableStateOf(30f) }
    var showEstimationBottomSheet by remember { mutableStateOf(false) }

    Scaffold(
        contentWindowInsets = WindowInsets(0.dp),
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(SiValetColor.White),
                title = {
                    TextBodyLargeBlack500(text = CoordinatorTaskStrings.HEADLINE)
                },
                navigationIcon = {
                    IconButton(
                        onClick = { onClickBack() }
                    ) {
                        Icon(
                            modifier = Modifier.height(24.dp),
                            painter = painterResource(id = R.drawable.ico_arrow_back),
                            contentDescription = null
                        )
                    }
                },
            )
        }
    ) { paddingValues->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(SiValetColor.SmoothWhite)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(vertical = 18.dp, horizontal = 17.dp)
                    .background(Color.Transparent),
                verticalArrangement = Arrangement.spacedBy(5.dp),
            ) {
                ComponentButtonDropdown(
                    isPlaceHolderText = false,
                    icon = painterResource(id = R.drawable.ico_tag),
                    placeholderText = CoordinatorTaskStrings.LABEL_TAG_ACTIVITY,
                    onClick = {
                        showBottomSheet = true
                    }
                )

                ComponentCoordinatorTextField(
                    icon = painterResource(id = R.drawable.ico_date_black),
                    placeholderText = CoordinatorTaskStrings.LABEL_PLACEHOLDER_DATE,
                    textField = date,
                    onValueChange = { date = it },
                )

                ComponentButtonDropdown(
                    icon = painterResource(id = R.drawable.ico_profile_gray),
                    placeholderText = CoordinatorTaskStrings.LABEL_PLACEHOLDER_CHOOSE_USER,
                    onClick = {
                        showBottomSheet = true
                    }
                )

                ComponentButtonDropdown(
                    icon = painterResource(id = R.drawable.ico_time_black),
                    placeholderText = CoordinatorTaskStrings.LABEL_PLACEHOLDER_ESTIMATION,
                    onClick = {
                        showEstimationBottomSheet = true
                    }
                )

                ComponentCoordinatorTextField(
                    icon = painterResource(id = R.drawable.ico_car_black),
                    placeholderText = CoordinatorTaskStrings.LABEL_PLACEHOLDER_POLICE_NUMBER,
                    textField = policeNumber,
                    onValueChange = { policeNumber = it },
                )

                ComponentButtonDropdown(
                    icon = painterResource(id = R.drawable.ico_car_black),
                    placeholderText = CoordinatorTaskStrings.LABEL_PLACEHOLDER_CAR_TYPE,
                    onClick = {
                        showBottomSheet = true
                    }
                )

                ComponentCoordinatorTextField(
                    icon = painterResource(id = R.drawable.ico_user),
                    placeholderText = CoordinatorTaskStrings.LABEL_PLACEHOLDER_CUSTOMER_NAME,
                    textField = customerName,
                    onValueChange = { customerName = it },
                )

                ComponentCoordinatorTextField(
                    icon = painterResource(id = R.drawable.ico_description),
                    placeholderText = CoordinatorTaskStrings.LABEL_PLACEHOLDER_TASK_DESC,
                    textField = taskDesc,
                    onValueChange = { taskDesc = it },
                )

                ComponentCoordinatorTextField(
                    icon = painterResource(id = R.drawable.ico_location_on),
                    placeholderText = CoordinatorTaskStrings.LABEL_PLACEHOLDER_ADDRESS,
                    textField = address,
                    onValueChange = { address = it },
                )

                ComponentButtonDropdown(
                    icon = painterResource(id = R.drawable.ico_car_key),
                    placeholderText = CoordinatorTaskStrings.LABEL_PLACEHOLDER_DRIVER_NAME,
                    onClick = {
                        showBottomSheet = true
                    }
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 15.dp)
                        .background(Color.Transparent)
                ) {
                    ComponentButton(
                        onClick = { onClickAddTask() },
                        labelButton = CoordinatorTaskStrings.LABEL_BUTTON_ADD_TASK,
                        isWithIcon = true,
                        painter = painterResource(id = R.drawable.ico_play_arrow),
                        colors = ButtonDefaults.buttonColors(SiValetColor.Primary),
                        tint = SiValetColor.White,
                    )
                }
            }
        }

        if (showBottomSheet) {
            ModalBottomSheet(
                containerColor = SiValetColor.White,
                onDismissRequest = {
                    showBottomSheet = false
                },
                sheetState = sheetState
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 16.dp, horizontal = 20.dp)
                        ) {
                            TextBodyMedium(
                                text = "Pickup",
                                color = SiValetColor.Black
                            )
                        }
                        HorizontalDivider(
                            color = SiValetColor.Gray
                        )
                    }

                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 16.dp, horizontal = 20.dp)
                        ) {
                            TextBodyMedium(
                                text = "Delivery",
                                color = SiValetColor.Black
                            )
                        }
                        HorizontalDivider(
                            color = SiValetColor.Gray
                        )
                    }

                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 16.dp, horizontal = 20.dp)
                        ) {
                            TextBodyMedium(
                                text = "Dinas Luar",
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

        if (showEstimationBottomSheet) {
            ModalBottomSheet(
                containerColor = SiValetColor.White,
                onDismissRequest = { showEstimationBottomSheet = false },
                sheetState = rememberModalBottomSheetState()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 16.dp)
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "* geser untuk mengganti durasi",
                        fontWeight = FontWeight.W400,
                        fontSize = 11.sp,
                        fontStyle = FontStyle.Italic,
                        textAlign = TextAlign.Right,
                    )
                    TextBodyMedium(
                        text = "${estimationTime.toInt()} menit",
                        color = SiValetColor.Black
                    )
                    Slider(
                        value = estimationTime,
                        onValueChange = { estimationTime = it },
                        valueRange = 30f..180f,
                        steps = 4, // Akan memberikan step tiap 30 menit
                        colors = SliderDefaults.colors(
                            thumbColor = SiValetColor.Primary,
                            activeTrackColor = SiValetColor.Primary
                        )
                    )
                    ComponentButton(
                        onClick = {
                            showEstimationBottomSheet = false
                        },
                        labelButton = "Atur Estimasi Waktu",
                        isWithIcon = false,
                        colors = ButtonDefaults.buttonColors(SiValetColor.Primary),
                        tint = SiValetColor.White
                    )
                }
            }
        }

    }
}