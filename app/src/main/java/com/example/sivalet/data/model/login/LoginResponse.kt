package com.example.sivalet.data.model.login

data class LoginResponse(
    val success: Boolean,
    val message: String,
    val data: LoginData?
)

data class LoginData(
    val token: String,
    val user: User
)

data class User(
    val fullName: String,
    val email: String,
    val phone: String,
    val address: String,
    val role: String
)