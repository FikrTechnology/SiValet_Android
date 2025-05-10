package com.example.sivalet.presentation.viewmodel.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sivalet.data.model.login.LoginRequest
import com.example.sivalet.data.network.RetrofitClient
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    fun login(emailOrUsername: String, password: String, onResult: (Boolean, String) -> Unit) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.login(
                    LoginRequest(emailOrUsername = emailOrUsername, password = password)
                )
                if (response.success) {
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