package com.example.sivalet.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.sivalet.R
import com.example.sivalet.presentation.component.general.InformationStatusOngoing
import com.example.sivalet.presentation.component.general.TextBodyMediumGray400
import com.example.sivalet.presentation.component.general.TextTitleMediumBlack600
import com.example.sivalet.presentation.component.general.TopBarHomeScreen
import com.example.sivalet.presentation.component.home.CardsHome
import com.example.sivalet.presentation.component.home.LazyColumnToDoList
import com.example.sivalet.presentation.component.home.PieChartSection
import com.example.sivalet.ui.theme.HomeStrings
import com.example.sivalet.ui.theme.SiValetColor

@Composable
fun HomeContent(
    onClickToDoList : () -> Unit
) {
    Scaffold(
        contentWindowInsets = WindowInsets(0.dp, 0.dp, 0.dp, 0.dp),
        containerColor = SiValetColor.White,

        topBar = {
            TopBarHomeScreen(
                profile = true,
                trailing = true,
                imgProfile = painterResource(id = R.drawable.img_profile),
                nameProfile = "Zainudin",
                imgTrailing = painterResource(id = R.drawable.ico_notification)
            )
        }
    ) {paddingValues ->
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
                TextTitleMediumBlack600(text = "Halo Zay!")
                Spacer(modifier = Modifier.height(2.dp))
                TextBodyMediumGray400(text = HomeStrings.LABEL_SPIRIT)
                Spacer(modifier = Modifier.height(14.dp))

                CardsHome(
                    title = HomeStrings.LABEL_TO_DO_LIST,
                    height = 213
                ) {
                    LazyColumnToDoList(
                        onClickToDoList = onClickToDoList
                    )
                }

                Spacer(modifier = Modifier.height(15.dp))

                CardsHome(
                    title = HomeStrings.LABEL_ACTIVITY,
                    height = 265
                ) {
                    PieChartSection()
                }
            }
        }
    }
}