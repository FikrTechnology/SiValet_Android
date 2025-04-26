package com.example.sivalet.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sivalet.R
import com.example.sivalet.presentation.component.OutlinedTextFieldLogin
import com.example.sivalet.presentation.component.TextBodyLargeWhite600
import com.example.sivalet.presentation.component.TextBodySmallOldBlue500
import com.example.sivalet.ui.theme.SiValetColor

@Preview(showBackground = true)
@Composable
fun LoginScreen() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Scaffold(
        contentWindowInsets = WindowInsets(0.dp, 0.dp, 0.dp, 0.dp)
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(SiValetColor.SmoothWhite)
        ){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(395.dp)
                    .clip(RoundedCornerShape(bottomStart = 59.dp, bottomEnd = 59.dp)) // clip dulu
                    .background( // background mengikuti clip
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                SiValetColor.GradientBlue,
                                SiValetColor.GradientPurple.copy(alpha = 0.2f)
                            )
                        )
                    )
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 30.dp, end = 30.dp, top = 160.dp, bottom = 0.dp)
                        .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                        .background(SiValetColor.SmoothWhite.copy(alpha = 0.2f))
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 13.dp, end = 13.dp, top = 184.dp, bottom = 220.dp)
                    .clip(RoundedCornerShape(25.dp))
                    .background(SiValetColor.White)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 28.dp, vertical = 40.dp)
                ) {
                    Image(
                        modifier = Modifier
                            .width(123.dp),
                        painter = painterResource(id = R.drawable.logo_login_png),
                        contentDescription = "Logo Login"
                    )

                    Spacer(modifier = Modifier.height(34.dp))

                    OutlinedTextFieldLogin(
                        labelName = "Email atau username",
                        value = username,
                        onValueChange = { username = it },
                        placeholder = "Masukkan email atau username",
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextFieldLogin(
                        labelName = "Password",
                        value = password,
                        onValueChange = { password = it },
                        placeholder = "Masukkan password",
                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ico_eye_hide),
                                contentDescription = "Icon Eye Hide"
                            )
                        }
                    )

                    Spacer(modifier = Modifier.height(25.dp))

                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(47.dp),
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(SiValetColor.Primary)
                    ) {
                        TextBodyLargeWhite600(text = "Masuk")
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        TextButton(
                            onClick = { /*TODO*/ }
                        ) {
                            TextBodySmallOldBlue500(text = "Lupa Password ?")
                        }
                    }
                }
            }
        }
    }
}