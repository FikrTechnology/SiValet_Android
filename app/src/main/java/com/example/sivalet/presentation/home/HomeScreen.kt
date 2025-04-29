package com.example.sivalet.presentation.home

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sivalet.R
import com.example.sivalet.presentation.component.CardsHome
import com.example.sivalet.presentation.component.InformationStatusOngoing
import com.example.sivalet.presentation.component.LazyColumnToDoList
import com.example.sivalet.presentation.component.TextBodyMediumBlack500
import com.example.sivalet.presentation.component.TextBodyMediumGray400
import com.example.sivalet.presentation.component.TextBodyMediumWhite500
import com.example.sivalet.presentation.component.TextTitleMediumBlack600
import com.example.sivalet.presentation.component.TopBarHomeScreen
import com.example.sivalet.ui.theme.HomeStrings
import com.example.sivalet.ui.theme.SiValetColor

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen(){
    Scaffold(
        contentWindowInsets = WindowInsets(0.dp, 0.dp, 0.dp, 0.dp),

        topBar = {
            TopBarHomeScreen(
                profile = true,
                trailing = true,
                imgProfile = painterResource(id = R.drawable.img_profile),
                nameProfile = "Zainudin",
                imgTrailing = painterResource(id = R.drawable.ico_notification)
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(SiValetColor.SmoothWhite)
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

                CardsHome(title = HomeStrings.LABEL_TO_DO_LIST) {
                    LazyColumnToDoList()
                }

//                CardsHome(title = HomeStrings.LABEL_ACTIVITY) {
//
//                }
            }
        }
    }
}