package com.example.ministryoffinance.domain.model

data class Employee (
    val id: Int,
    val fullName: String,
    val position: String,
    val landlineNumber: String,
    val extensionNumber: String,
    val email: String,
    val room: Int,
    val categoryId: Int,
    val image: String?,
)