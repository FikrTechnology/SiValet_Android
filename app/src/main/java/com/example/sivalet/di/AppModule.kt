package com.example.sivalet.di

import com.example.sivalet.presentation.viewmodel.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { LoginViewModel() }
}