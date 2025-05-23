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
import com.example.sivalet.presentation.task.TaskCoordinatorScreen
import com.example.sivalet.presentation.task.TaskScreen
import com.example.sivalet.presentation.viewmodel.login.LoginViewModel

@Composable
fun HomeScreen(
    onClickConfirm: () -> Unit = {},
    onClickLogout: () -> Unit = {},
    onClickChooseTask: () -> Unit = {},
    loginViewModel: LoginViewModel
){
    val userData = loginViewModel.userData
    val navController = rememberNavController()
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStack?.destination?.route
    val isCoordinator = userData?.user?.role != "driver"
    val isUser = false
    val items = if (isUser) {
        listOf(
            Screen.Home,
            Screen.History,
            Screen.Account
        )
    } else {
        listOf(
            Screen.Home,
            Screen.Task,
            Screen.History,
            Screen.Account
        )
    }

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
                    },
                    isCoordinator = isCoordinator,
                    loginViewModel = loginViewModel
                )
            }
            if (!isUser){
                composable(Screen.Task.route) {
                    if (isCoordinator) {
                        TaskCoordinatorScreen(
                            onClickBack = {
                                navController.popBackStack()
                            },
                            onClickAddTask = {
                                navController.popBackStack()
                            }
                        )
                    } else {
                        TaskScreen(
                            onClickConfirm = {
                                onClickConfirm()
                            },
                            onClickChooseTask = {
                                onClickChooseTask()
                            },
                        )
                    }
                }
            }
            composable(Screen.History.route) {
                HistoryScreen()
            }
            composable(Screen.Account.route) {
                AccountScreen(
                    onClickLogout = {
                        onClickLogout()
                    },
                    loginViewModel = loginViewModel
                )
            }
        }
    }
}
