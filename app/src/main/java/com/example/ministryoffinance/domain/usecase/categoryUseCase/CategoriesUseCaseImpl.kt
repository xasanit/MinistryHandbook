package com.example.ministryoffinance.domain.usecase.categoryUseCase

import com.example.ministryoffinance.data.repository.categoryRepository.CategoryRepository
import com.example.ministryoffinance.domain.model.Category

class CategoriesUseCaseImpl(
    val repository: CategoryRepository
) : CategoryUseCase {
    override suspend fun getCategoriesUseCase(): List<Category> {
        return repository.getCategories()
    }
}