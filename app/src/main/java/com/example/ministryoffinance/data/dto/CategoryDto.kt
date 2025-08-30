package com.example.ministryoffinance.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class CategoryDto (
    val id: Int,
    val kgName: String,
    val ruName: String,
    val index: Int,
    val createdAt: String,
    val updatedAt: String,
)
