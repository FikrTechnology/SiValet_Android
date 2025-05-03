package com.example.sivalet.presentation.task

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sivalet.R
import com.example.sivalet.presentation.component.general.CardTag
import com.example.sivalet.presentation.component.general.TextBodyLargeBlack500
import com.example.sivalet.presentation.component.general.TextBodyMediumBlack500
import com.example.sivalet.presentation.component.general.TextBodyMediumGray400
import com.example.sivalet.presentation.component.general.TextBodySmallGray400
import com.example.sivalet.presentation.component.task.ContentConfirmationTask
import com.example.sivalet.presentation.component.task.HeaderConfirmationTask
import com.example.sivalet.ui.theme.ConfirmTaskStrings
import com.example.sivalet.ui.theme.SiValetColor

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ConfirmationTaskScreen(
    onClickClockIn: () -> Unit = {},
    onCliCkBack: () -> Unit = {}
) {
    var locationFrom by remember { mutableStateOf("") }
    var locationTo by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var customer by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier
            .safeDrawingPadding(),
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(SiValetColor.BorderColor),
                title = {
                    TextBodyLargeBlack500(text = ConfirmTaskStrings.HEADLINE)
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            onCliCkBack()
                        }
                    ) {
                        Icon(
                            modifier = Modifier.height(24.dp),
                            painter = painterResource(id = R.drawable.ico_arrow_back),
                            contentDescription = null
                        )
                    }
                },
            )
        },
        contentWindowInsets = WindowInsets(0.dp)
    ) {paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(SiValetColor.SmoothWhite)
        ) {
            HeaderConfirmationTask(
                name = "Zainudin",
                os = "via Android OS",
                date = "21 March 2025 09:22"
            )

            ContentConfirmationTask(
                carName = "RAIZE B55SKU",
                activityType = "Pickup",
                textFieldLocFrom = locationFrom,
                onValueChangeLocFrom = { locationFrom = it },
                textFieldLocTo = locationTo,
                onValueChangeLocTo = { locationTo = it },
                textFieldUser = username,
                onValueChangeUser = { username = it },
                textFieldCustomer = customer,
                onValueChangeCustomer = { customer = it }
            )
        }
    }
}