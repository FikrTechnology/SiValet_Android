package com.example.sivalet.data.model.login

data class LoginRequest(
    val emailOrUsername: String,
    val password: String
)