package com.example.ministryoffinance.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ministryoffinance.domain.model.Category
import com.example.ministryoffinance.domain.usecase.categoryUseCase.CategoryUseCase
import kotlinx.coroutines.launch

class CategoryViewModel (
    val categoryUseCase: CategoryUseCase,
): ViewModel() {

    private val categoriesCache = mutableListOf<Category>()     //объявляется в качестве обычного изменяемого списка

    private val _categories = mutableStateListOf<Category>()
    val categories: List<Category> get() = _categories          //опять же, делается только для чтения

    var isLoading by mutableStateOf(false)
        private set

    fun getCategories() {
        viewModelScope.launch {

            Log.d("CategoriesViewModel", "Загрузка всех категорий (размер=${categories.size})")

            if(categoriesCache.isNotEmpty()) {
                _categories.clear()     //очищается во избежаниe дубликатов
                _categories.addAll(categoriesCache)
                return@launch       //досрочный выход из корутины
            }

            isLoading = true

            try {

                val result = categoryUseCase.getCategoriesUseCase()

                categoriesCache.clear()
                categoriesCache.addAll(result)

                _categories.clear()
                _categories.addAll(result)

            } catch (e: Exception) {
                Log.e("CategoryViewModel", "Ошибка при загрузке данных: ${e.message}")
            } finally {
                isLoading = false
            }
        }
    }
}