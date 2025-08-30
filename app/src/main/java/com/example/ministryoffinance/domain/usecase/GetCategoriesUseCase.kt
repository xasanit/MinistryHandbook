package com.example.ministryoffinance.domain.usecase

import com.example.ministryoffinance.data.repository.categoryRepository.CategoryRepository
import com.example.ministryoffinance.domain.model.Category

class GetCategoriesUseCase(
    val repository: CategoryRepository
) {
    suspend operator fun invoke(): List<Category> {
        return repository.getCategories()
    }
}