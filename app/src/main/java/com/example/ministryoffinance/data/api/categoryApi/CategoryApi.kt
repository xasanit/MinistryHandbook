package com.example.ministryoffinance.data.api.categoryApi

import com.example.ministryoffinance.data.dto.CategoryDto

interface CategoryApi {

    suspend fun getCategories(): List<CategoryDto>

    suspend fun getCategory(id: Int): CategoryDto

}