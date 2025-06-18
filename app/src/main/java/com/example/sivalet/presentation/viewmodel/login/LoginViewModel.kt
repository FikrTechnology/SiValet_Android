package com.example.sivalet.presentation.viewmodel.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sivalet.data.model.home.TaskItem
import com.example.sivalet.data.model.login.LoginData
import com.example.sivalet.data.model.login.LoginRequest
import com.example.sivalet.data.network.RetrofitClient
import com.google.gson.Gson
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    var userData by mutableStateOf<LoginData?>(null)
        private set

    var isLoading by mutableStateOf(false)
        private set

    fun updateUserData(data: LoginData) {
        userData = data
    }

    var assignedTasks = mutableListOf<TaskItem>()
        private set

    var token: String? = null
        private set

    fun login(emailOrUsername: String, password: String, onResult: (Boolean, String) -> Unit) {
        viewModelScope.launch {
            isLoading = true
            try {
                val request = LoginRequest(emailOrUsername = emailOrUsername, password = password)
                println("LoginRequest: $request") // Log the request
                val response = RetrofitClient.apiService.login(request)

                // Konversi response ke JSON
                val jsonResponse = Gson().toJson(response)
                println("Response JSON: $jsonResponse")

                if (response.success) {
                    token = response.data?.token
                    RetrofitClient.tokenProvider = { token }
                    userData = response.data
                    onResult(true, response.message)
                } else {
                    onResult(false, response.message)
                }
            } catch (e: Exception) {
                onResult(false, e.message ?: "An error occurred")
            } finally {
                isLoading = false
                println("isLoading set to false")
            }
        }
    }

    fun fetchTasks(onResult: (Boolean, String) -> Unit) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.getTasks()
                // Konversi response ke JSON
                val jsonResponse = Gson().toJson(response)
                println("Response JSON: $jsonResponse")

                if (response.success) {
                    assignedTasks = if (userData?.user?.role == "coordinator") {
                        response.data.tasks.toMutableList() // Tidak difilter
                    } else {
                        response.data.tasks.filter { it.progress == "assigned" }.toMutableList() // Difilter
                    }
                    println("Assigned Tasks: $assignedTasks")
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