package com.example.ministryoffinance.domain.repository

import com.example.ministryoffinance.domain.model.Category

interface CategoryRepository {

    suspend fun getCategories(): List<Category>

    suspend fun getCategory(id: Int): Category

}