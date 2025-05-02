package com.example.sivalet.presentation.home

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.sivalet.navigation.Screen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sivalet.presentation.account.AccountScreen
import com.example.sivalet.presentation.component.general.RoundedBottomBar
import com.example.sivalet.presentation.history.HistoryScreen
import com.example.sivalet.presentation.task.ConfirmationTaskScreen
import com.example.sivalet.presentation.task.TaskScreen

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen(
    onClickConfirm: () -> Unit = {},
){
    val items = listOf(
        Screen.Home,
        Screen.Task,
        Screen.History,
        Screen.Account
    )
    val navController = rememberNavController()
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStack?.destination?.route

    Scaffold(
        modifier = Modifier.safeDrawingPadding(),
        containerColor = Color.Transparent,
        contentWindowInsets = WindowInsets(0),
        bottomBar = {
            RoundedBottomBar(
                items = items,
                currentRoute = currentRoute,
                onItemSelected = { route ->
                    navController.navigate(route) {
                        if (route != Screen.Home.route){
                            popUpTo(Screen.Home.route) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        } else {
                            popUpTo(0)
                            launchSingleTop = true
                        }
                    }
                }
            )
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(
                start = paddingValues.calculateStartPadding(LayoutDirection.Ltr),
                top = paddingValues.calculateTopPadding(),
                end = paddingValues.calculateEndPadding(LayoutDirection.Ltr),
                bottom = 0.dp
            )
        ) {
            composable(Screen.Home.route) {
                HomeContent(
                    onClickToDoList = {
                        navController.navigate(Screen.Task.route)
                    }
                )
            }
            composable(Screen.Task.route) {
                TaskScreen(
                    onClickConfirm = {
                        onClickConfirm()
                    }
                )
            }
            composable(Screen.History.route) {
                HistoryScreen()
            }
            composable(Screen.Account.route) {
                AccountScreen()
            }
        }
    }
}
