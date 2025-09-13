package com.example.ministryoffinance.data.fake

import android.util.Log
import com.example.ministryoffinance.domain.repository.CategoryRepository
import com.example.ministryoffinance.domain.model.Category
import com.example.ministryoffinance.data.fake.mock.mockCategoryList

class FakeCategoryRepositoryImpl: CategoryRepository {

    override suspend fun getCategories(): List<Category> {
        return mockCategoryList
    }

    override suspend fun getCategory(id: Int): Category {
        var index = 0
        var i = -1
        for (category in mockCategoryList) {
            i++
            if (id == category.id) {
                index = i
                break
            }
        }
        Log.d("FakeCategoryRepositoryImplementation", "Current category: ${mockCategoryList[index]}")
        return mockCategoryList[index]
    }
}