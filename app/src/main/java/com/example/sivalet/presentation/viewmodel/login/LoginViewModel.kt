package com.example.sivalet.presentation.viewmodel.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sivalet.data.model.login.LoginData
import com.example.sivalet.data.model.login.LoginRequest
import com.example.sivalet.data.network.RetrofitClient
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    var userData by mutableStateOf<LoginData?>(null)
        private set

    fun updateUserData(data: LoginData) {
        userData = data
    }

    fun login(emailOrUsername: String, password: String, onResult: (Boolean, String) -> Unit) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.login(
                    LoginRequest(emailOrUsername = emailOrUsername, password = password)
                )
                if (response.success) {
                    userData = response.data
                    onResult(true, response.message)
                } else {
                    onResult(false, response.message)
                }
            } catch (e: Exception) {
                onResult(false, e.message ?: "An error occurred")
            }
        }
    }
}