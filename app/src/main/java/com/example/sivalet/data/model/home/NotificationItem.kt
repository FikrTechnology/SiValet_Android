package com.example.sivalet.data.model.home

data class NotificationItem(
    val id: Int,
    val message: String,
    val isRead: Boolean = false
)