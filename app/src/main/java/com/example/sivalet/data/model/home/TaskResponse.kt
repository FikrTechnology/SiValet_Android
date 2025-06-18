package com.example.sivalet.data.model.home

import com.google.gson.annotations.SerializedName

data class TaskResponse(
    @SerializedName("success") val success: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: TaskData
)

data class TaskData(
    @SerializedName("tasks") val tasks: List<TaskItem>
)

data class TaskItem(
    @SerializedName("task_id") val taskId: Int,
    @SerializedName("coordinator") val coordinator: Coordinator,
    @SerializedName("driver") val driver: Driver,
    @SerializedName("user") val user: User,
    @SerializedName("customer") val customer: Customer,
    @SerializedName("vechicle") val vehicle: Vehicle,
    @SerializedName("description") val description: String,
    @SerializedName("assigned_at") val assignedAt: String,
    @SerializedName("progress") val progress: String,
    @SerializedName("type") val type: String,
    @SerializedName("location") val location: String,
    @SerializedName("estimation") val estimation: String,
    @SerializedName("assignment") val assignment: String,
)

data class Coordinator(@SerializedName("name") val name: String)
data class Driver(@SerializedName("name") val name: String)
data class User(@SerializedName("name") val name: String)
data class Customer(@SerializedName("name") val name: String)
data class Vehicle(
    @SerializedName("license_plate") val licensePlate: String,
    @SerializedName("type") val type: String,
)
