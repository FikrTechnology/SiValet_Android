package com.example.sivalet.presentation.task

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
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
import com.example.sivalet.presentation.component.task.ComponentButtonDropdown
import com.example.sivalet.presentation.component.task.ComponentCoordinatorTextField
import com.example.sivalet.ui.theme.CoordinatorTaskStrings
import com.example.sivalet.ui.theme.SiValetColor

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun TaskCoordinatorScreen() {
    var date by remember { mutableStateOf("") }
    var policeNumber by remember { mutableStateOf("") }
    var customerName by remember { mutableStateOf("") }
    var taskDesc by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }

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
                        onClick = {}
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
                    placeholderText = CoordinatorTaskStrings.LABEL_TAG_ACTIVITY
                )

                ComponentCoordinatorTextField(
                    icon = painterResource(id = R.drawable.ico_date_black),
                    placeholderText = CoordinatorTaskStrings.LABEL_PLACEHOLDER_DATE,
                    textField = date,
                    onValueChange = { date = it },
                )

                ComponentButtonDropdown(
                    icon = painterResource(id = R.drawable.ico_profile_gray),
                    placeholderText = CoordinatorTaskStrings.LABEL_PLACEHOLDER_CHOOSE_USER
                )

                ComponentButtonDropdown(
                    icon = painterResource(id = R.drawable.ico_time_black),
                    placeholderText = CoordinatorTaskStrings.LABEL_PLACEHOLDER_ESTIMATION
                )

                ComponentCoordinatorTextField(
                    icon = painterResource(id = R.drawable.ico_car_black),
                    placeholderText = CoordinatorTaskStrings.LABEL_PLACEHOLDER_POLICE_NUMBER,
                    textField = policeNumber,
                    onValueChange = { policeNumber = it },
                )

                ComponentButtonDropdown(
                    icon = painterResource(id = R.drawable.ico_car_black),
                    placeholderText = CoordinatorTaskStrings.LABEL_PLACEHOLDER_CAR_TYPE
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
                    placeholderText = CoordinatorTaskStrings.LABEL_PLACEHOLDER_DRIVER_NAME
                )
            }
        }
    }
}