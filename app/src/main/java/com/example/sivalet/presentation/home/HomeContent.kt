package com.example.sivalet.presentation.home

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.sivalet.R
import com.example.sivalet.data.model.home.NotificationItem
import com.example.sivalet.presentation.component.general.ComponentTopBar
import com.example.sivalet.presentation.component.general.InformationStatusOngoing
import com.example.sivalet.presentation.component.general.TextBodyMediumGray400
import com.example.sivalet.presentation.component.general.TextTitleMediumBlack600
import com.example.sivalet.presentation.component.general.ComponentCard
import com.example.sivalet.presentation.component.general.TextBodyMediumWhite500
import com.example.sivalet.presentation.component.home.LazyColumnDriverList
import com.example.sivalet.presentation.component.home.LazyColumnToDoList
import com.example.sivalet.presentation.component.home.NotificationList
import com.example.sivalet.presentation.component.home.PieChartSection
import com.example.sivalet.presentation.viewmodel.login.LoginViewModel
import com.example.sivalet.ui.theme.HomeStrings
import com.example.sivalet.ui.theme.SiValetColor

@Composable
fun HomeContent(
    onClickToDoList : () -> Unit,
    isCoordinator: Boolean = false,
    loginViewModel: LoginViewModel
) {
    val userData = loginViewModel.userData
    var showNotificationList by remember { mutableStateOf(false) }

    // Notification state
    var notifications by remember {
        mutableStateOf(
            listOf(
                NotificationItem(1, "Pickup B66ASKU ke Kawan Lama", false),
                NotificationItem(2, "Delivery B12XYZ ke Toko ABC", false),
                NotificationItem(3, "Pickup B34LMN ke Kawan Baru", false),
            )
        )
    }

    BackHandler(enabled = showNotificationList) {
        showNotificationList = false
    }

    Scaffold(
        contentWindowInsets = WindowInsets(0.dp, 0.dp, 0.dp, 0.dp),
        containerColor = SiValetColor.White,

        topBar = {
            ComponentTopBar(
                profile = true,
                trailing = true,
                imgProfile = painterResource(id = R.drawable.img_profile),
                nameProfile = userData?.user?.fullname,
                imgTrailing = painterResource(id = R.drawable.ico_notification),
                borderBottom = true,
                onClickTrailing = { showNotificationList = !showNotificationList }
            )
        }
    ) {paddingValues ->
        if (showNotificationList) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(SiValetColor.SmoothWhite)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                ) {
                    TextTitleMediumBlack600(text = HomeStrings.LABEL_TITLE_NOTIFICATION)
                    Spacer(modifier = Modifier.height(2.dp))
                    TextBodyMediumGray400(text = HomeStrings.LABEL_SUBTITLE_NOTIFICATION)
                    Spacer(modifier = Modifier.height(11.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Button(
                            modifier = Modifier
                                .height(35.dp),
                            onClick = {
                                // Mark all as read
                                notifications = notifications.map { it.copy(isRead = true) }
                            },
                            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 0.dp),
                            colors = ButtonDefaults.buttonColors(SiValetColor.Primary)
                        ) {
                            TextBodyMediumWhite500(text = HomeStrings.LABEL_READ)
                        }

                        Button(
                            modifier = Modifier
                                .height(35.dp),
                            onClick = {
                                // Delete all notifications
                                notifications = emptyList()
                            },
                            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 0.dp),
                            colors = ButtonDefaults.buttonColors(SiValetColor.Danger)
                        ) {
                            TextBodyMediumWhite500(text = HomeStrings.LABEL_DELETE)
                        }
                    }

                    Spacer(modifier = Modifier.height(18.dp))

                    NotificationList(
                        notifications = notifications,
                        onNotificationClick = { notif ->
                            notifications = notifications.map {
                                if (it.id == notif.id) it.copy(isRead = true) else it
                            }
                        }
                    )
                }
            }
        } else {
            Box {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            start = paddingValues.calculateStartPadding(LayoutDirection.Ltr),
                            top = paddingValues.calculateTopPadding(),
                            end = paddingValues.calculateEndPadding(LayoutDirection.Ltr),
                            bottom = 0.dp
                        )
                        .background(SiValetColor.SmoothWhite)
                        .verticalScroll(rememberScrollState())
                ) {
                    InformationStatusOngoing()

                    Column(
                        modifier = Modifier
                            .padding(horizontal = 18.dp, vertical = 20.dp)
                    ) {
                        TextTitleMediumBlack600(text = "Halo ${userData?.user?.fullname}!")
                        Spacer(modifier = Modifier.height(2.dp))
                        TextBodyMediumGray400(text = if (!isCoordinator) HomeStrings.LABEL_SPIRIT else HomeStrings.LABEL_SPIRIT_COORDINATOR)
                        Spacer(modifier = Modifier.height(14.dp))

                        if (!isCoordinator) {
                            ComponentCard(
                                title = HomeStrings.LABEL_TO_DO_LIST,
                                height = 213
                            ) {
                                LazyColumnToDoList(
                                    onClickToDoList = onClickToDoList
                                )
                            }
                        } else {
                            ComponentCard(
                                title = HomeStrings.LABEL_DRIVER_STATUS,
                                height = 356
                            ) {
                                LazyColumnDriverList()
                            }
                        }

                        Spacer(modifier = Modifier.height(15.dp))

                        ComponentCard(
                            title = HomeStrings.LABEL_ACTIVITY,
                            height = 265
                        ) {
                            PieChartSection()
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun TestHome() {
    HomeContent(
        onClickToDoList = {},
        isCoordinator = false,
        loginViewModel = LoginViewModel()
    )
}