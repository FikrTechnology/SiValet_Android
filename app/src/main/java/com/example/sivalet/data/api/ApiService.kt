package com.example.sivalet.data.api

import com.example.sivalet.data.model.login.LoginRequest
import com.example.sivalet.data.model.login.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): LoginResponse
}