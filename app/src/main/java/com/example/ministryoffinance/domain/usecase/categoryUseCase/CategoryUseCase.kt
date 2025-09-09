package com.example.ministryoffinance.domain.usecase.categoryUseCase

import com.example.ministryoffinance.domain.model.Category

interface CategoryUseCase {
    suspend fun getCategoriesUseCase(): List<Category>
}