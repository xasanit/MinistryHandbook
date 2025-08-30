package com.example.ministryoffinance.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class EmployeeDto(
    val id: Int,
    val index: Int,
    val firstName: String,
    val lastName: String,
    val middleName: String,
    val landlineNumber: String,
    val extensionNumber: String,
    val email: String,
    val room: Int,
    val categoryId: Int,
    val position: String,
    val image: String,
    val createdAt: String,
    val updatedAt: String,
    val category: EmployeeCategoryDto
)

@Serializable
data class EmployeeListResponse(
    val count: Int,
    val rows: List<EmployeeDto>
)

@Serializable
data class EmployeeCategoryDto(
    val kgName: String,
    val ruName: String
)