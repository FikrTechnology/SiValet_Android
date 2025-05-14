package com.example.sivalet.presentation.account

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sivalet.R
import com.example.sivalet.presentation.component.account.ComponentContentTable
import com.example.sivalet.presentation.component.general.ComponentButton
import com.example.sivalet.presentation.component.general.ComponentCard
import com.example.sivalet.presentation.component.general.TextBodyLargeBlack500
import com.example.sivalet.presentation.component.general.TextBodyMediumGray400
import com.example.sivalet.presentation.viewmodel.login.LoginViewModel
import com.example.sivalet.ui.theme.AccountStrings
import com.example.sivalet.ui.theme.SiValetColor

@Composable
fun AccountScreen(
    onClickLogout: () -> Unit = {},
    loginViewModel: LoginViewModel
){
    val userData = loginViewModel.userData

    Scaffold(
        contentWindowInsets = WindowInsets(
            top = 31.dp,
            bottom = 0.dp,
            left = 17.dp,
            right = 17.dp
        ),
    ) { paddingValues->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(SiValetColor.SmoothWhite),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .size(104.dp),
                    painter = painterResource(id = R.drawable.img_profile),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.height(14.dp))
                TextBodyLargeBlack500(text = "${userData?.user?.fullname}")
                TextBodyMediumGray400(text = "${userData?.user?.role}")
            }

            ComponentCard(
                title = AccountStrings.LABEL_TABLE,
                height = 270,
                colorBackgroundTitle = SiValetColor.SmoothWhite
            ) {
                ComponentContentTable(
                    accountName = "${userData?.user?.role}",
                    accountPhone = "0857 xxxx xxxx"
                )
            }

            ComponentButton(
                onClick = onClickLogout,
                colors = ButtonDefaults.buttonColors(SiValetColor.BorderColor),
                isWithIcon = true,
                isTextColorWhite = false,
                painter = painterResource(id = R.drawable.ico_logout),
                tint = SiValetColor.Primary,
                labelButton = AccountStrings.LABEL_BUTTON
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextBodyMediumGray400(
                    text = AccountStrings.LABEL_VERSION,
                    fontWeight = FontWeight.W500
                )
                Spacer(modifier = Modifier.height(6.dp))
                TextBodyMediumGray400(
                    text = AccountStrings.LABEL_COPY_RIGHT,
                    fontWeight = FontWeight.W500
                )
            }
        }
    }
}