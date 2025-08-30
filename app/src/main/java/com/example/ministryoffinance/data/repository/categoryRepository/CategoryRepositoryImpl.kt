package com.example.ministryoffinance.data.repository.categoryRepository

import com.example.ministryoffinance.data.api.categoryApi.CategoryApi
import com.example.ministryoffinance.data.mapping.toDomain
import com.example.ministryoffinance.domain.model.Category

class CategoryRepositoryImpl (
    val api: CategoryApi
): CategoryRepository {
    override suspend fun getCategories(): List<Category> {
        return api.getCategories().map {it.toDomain()}
    }

    override suspend fun getCategory(id: Int): Category {
        return api.getCategory(id).toDomain()
    }
}