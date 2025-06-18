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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sivalet.R
import com.example.sivalet.data.model.login.LoginData
import com.example.sivalet.presentation.component.general.ComponentButton
import com.example.sivalet.presentation.component.general.TextBodyMedium
import com.example.sivalet.presentation.component.login.OutlinedTextFieldLogin
import com.example.sivalet.presentation.component.general.TextBodySmallOldBlue500
import com.example.sivalet.presentation.viewmodel.login.LoginViewModel
import com.example.sivalet.ui.theme.LoginStrings
import com.example.sivalet.ui.theme.SiValetColor
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(
    onClickMasuk : (LoginData) -> Unit,
    onClickForgotPass : () -> Unit,
    viewModel: LoginViewModel = koinViewModel()
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var usernameError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }

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
                    .clip(RoundedCornerShape(bottomStart = 59.dp, bottomEnd = 59.dp))
                    .background(
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
                    .wrapContentHeight()
                    .padding(start = 13.dp, end = 13.dp, top = 184.dp)
                    .clip(RoundedCornerShape(25.dp))
                    .background(SiValetColor.White)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
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
                        labelName = LoginStrings.LABEL_USERNAME,
                        value = username,
                        onValueChange = {
                            username = it
                            usernameError = false
                        },
                        placeholder = LoginStrings.PLACEHOLDER_USERNAME,
                        keyboardType = KeyboardType.Email
                    )
                    if (usernameError) {
                        TextBodyMedium(text = "Username cannot be empty", color = SiValetColor.Red)
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextFieldLogin(
                        labelName = LoginStrings.LABEL_PASSWORD,
                        value = password,
                        onValueChange = {
                            password = it
                            passwordError = false
                        },
                        placeholder = LoginStrings.PLACEHOLDER_PASSWORD,
                        trailingIcon = {
                            val image = if (passwordVisible)
                                painterResource(id = R.drawable.ico_eye_hide)
                            else
                                painterResource(id = R.drawable.ico_eye_hide)

                            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                Icon(
                                    painter = image,
                                    contentDescription = if (passwordVisible) "Hide password" else "Show password"
                                )
                            }
                        },
                        keyboardType = KeyboardType.Password,
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
                    )
                    if (passwordError) {
                        TextBodyMedium(text = "Password cannot be empty", color = SiValetColor.Red)
                    }

                    Spacer(modifier = Modifier.height(25.dp))

                    ComponentButton(
                        onClick = {
                            var hasError = false
                            if (username.isBlank()) {
                                usernameError = true
                                hasError = true
                            }
                            if (password.isBlank()) {
                                passwordError = true
                                hasError = true
                            }
                            if (!hasError) {
                                viewModel.login(username, password) { success, message ->
                                    val userData = viewModel.userData
                                    if (success && userData != null) {
                                        viewModel.fetchTasks { taskSuccess, taskMessage ->
                                            if (taskSuccess) {
                                                onClickMasuk(
                                                    userData
                                                )
                                            } else {
                                                println("Failed to fetch tasks: $taskMessage")
                                            }
                                        }
                                    } else {
                                        println("Login failed: $message")
                                    }
                                }
                            }
                        },
                        colors = ButtonDefaults.buttonColors(SiValetColor.Primary),
                        labelButton = LoginStrings.BUTTON_MASUK
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        TextButton(
                            onClick = { onClickForgotPass() }
                        ) {
                            TextBodySmallOldBlue500(text = LoginStrings.TEXT_BUTTON_FORGOT_PASS)
                        }
                    }
                }
            }

            if (viewModel.isLoading) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(SiValetColor.SmoothWhite.copy(alpha = 0.5f)),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(color = SiValetColor.Primary)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        onClickMasuk = {},
        onClickForgotPass = {}
    )
}