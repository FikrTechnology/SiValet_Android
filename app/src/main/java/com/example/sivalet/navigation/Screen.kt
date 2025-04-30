package com.example.sivalet.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Home : Screen("home")
    object Task : Screen("task")
    object ConfirmTask : Screen("confirm_task")
    object History : Screen("history")
    object Account : Screen("account")
    object ForgotPassword : Screen("forgot_password")
}