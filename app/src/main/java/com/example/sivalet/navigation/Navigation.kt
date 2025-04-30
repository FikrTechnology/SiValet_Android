package com.example.sivalet.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sivalet.presentation.home.HomeScreen
import com.example.sivalet.presentation.login.LoginScreen

@Composable
fun SetupNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(route = Screen.Login.route) {
            LoginScreen(
                onClickMasuk = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(0)
                    }
                },
                onClickForgotPass = {}
            )
        }
        composable(route = Screen.Home.route) {
            HomeScreen()
        }
        composable(route = Screen.ConfirmTask.route) {}
        composable(route = Screen.ForgotPassword.route) {}
    }
}