package com.example.sivalet.presentation.task

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sivalet.R
import com.example.sivalet.presentation.component.general.TextBodyLargeBlack500
import com.example.sivalet.presentation.component.general.TextBodyMediumGray400
import com.example.sivalet.presentation.component.general.TextBodySmallGray400
import com.example.sivalet.ui.theme.ConfirmTaskStrings
import com.example.sivalet.ui.theme.SiValetColor

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ConfirmationTaskScreen(
    onClickClockIn: () -> Unit = {},
    onCliCkBack: () -> Unit = {}
) {
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
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(SiValetColor.BorderColor)
                    .padding(horizontal = 26.dp, vertical = 36.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .width(73.dp)
                        .height(73.dp),
                    painter = painterResource(id = R.drawable.img_profile),
                    contentDescription = "Image Profile"
                )
                Spacer(modifier = Modifier.width(43.dp))
                Column(
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    TextBodyLargeBlack500(text = "Zainudin")
                    TextBodyMediumGray400(text = "via Android OS")
                    TextBodySmallGray400(text = "21 March 2025 09:22")
                }
            }
        }
    }
}