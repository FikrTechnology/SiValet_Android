package com.example.sivalet.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
}