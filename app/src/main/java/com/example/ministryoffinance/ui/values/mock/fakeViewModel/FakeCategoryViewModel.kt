package com.example.ministryoffinance.ui.values.mock.fakeViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ministryoffinance.domain.model.Category
import com.example.ministryoffinance.ui.values.mock.fakeUseCase.FakeGetCategoriesUseCase
import kotlinx.coroutines.launch

class FakeCategoryViewModel (
    val useCase: FakeGetCategoriesUseCase
) : ViewModel() {

    val categoryList = mutableListOf<Category>()

    var isLoading by mutableStateOf(false)
        private set

    fun getCategories() {
        viewModelScope.launch {
            val result = useCase()
        }
    }
}