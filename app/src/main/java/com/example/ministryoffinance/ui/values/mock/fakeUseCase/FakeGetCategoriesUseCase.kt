package com.example.ministryoffinance.ui.values.mock.fakeUseCase

import com.example.ministryoffinance.data.repository.categoryRepository.CategoryRepository
import com.example.ministryoffinance.ui.values.mock.data.mockCategoryList
import com.example.ministryoffinance.domain.model.Category

class FakeGetCategoriesUseCase(
    val repository: CategoryRepository
) {
    suspend operator fun invoke(): List<Category> {
        return mockCategoryList
    }
}