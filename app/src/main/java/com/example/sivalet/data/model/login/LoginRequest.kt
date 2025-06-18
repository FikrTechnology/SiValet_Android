package com.example.sivalet.data.model.login

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("email_or_username") val emailOrUsername: String,
    @SerializedName("password") val password: String
)