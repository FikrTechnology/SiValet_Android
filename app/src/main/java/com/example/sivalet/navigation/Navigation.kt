package com.example.sivalet.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sivalet.presentation.home.HomeScreen
import com.example.sivalet.presentation.login.LoginScreen
import com.example.sivalet.presentation.task.ChooseTaskScreen
import com.example.sivalet.presentation.task.ConfirmationTaskScreen
import com.example.sivalet.presentation.viewmodel.login.LoginViewModel

@Composable
fun SetupNavigation() {
    val navController = rememberNavController()
    val loginViewModel: LoginViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(route = Screen.Login.route) {
            LoginScreen(
                onClickMasuk = { loginData ->
                    loginViewModel.updateUserData(loginData)
                    navController.navigate(Screen.Home.route) {
                        popUpTo(0)
                    }
                },
                onClickForgotPass = {}
            )
        }
        composable(route = Screen.Home.route) {
            HomeScreen(
                onClickConfirm = {
                    navController.navigate(Screen.ConfirmTask.route)
                },
                onClickLogout = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(0)
                    }
                },
                onClickChooseTask = {
                    navController.navigate(Screen.ChooseTask.route)
                },
                loginViewModel = loginViewModel
            )
        }
        composable(route = Screen.ForgotPassword.route) {}
        composable(Screen.ConfirmTask.route) {
            ConfirmationTaskScreen(
                onClickClockIn = {
                    navController.popBackStack()
                },
                onCliCkBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(route = Screen.ChooseTask.route) {
            ChooseTaskScreen(
                onClickBack = {
                    navController.popBackStack()
                },
                onClickItem = {
                    navController.popBackStack()
                }
            )
        }
    }
}