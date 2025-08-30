package com.example.ministryoffinance.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ministryoffinance.domain.model.Employee
import com.example.ministryoffinance.domain.usecase.GetEmployeesUseCase
import kotlinx.coroutines.launch

class EmployeeViewModel(
    private val getEmployeesUseCase: GetEmployeesUseCase,
) : ViewModel() {

    private val employeesCache = mutableMapOf<Pair<Int, String>, List<Employee>>() // ключ: categoryId + search

    private val _employees = mutableStateListOf<Employee>()
    val employees: List<Employee> get() = _employees

    var isLoading by mutableStateOf(false)
        private set

    var searchQuery by mutableStateOf("")
        private set

    var selectedCategoryId: Int? by mutableStateOf(1)
        private set

    fun onCategorySelected(categoryId: Int) {
        selectedCategoryId = categoryId
        loadEmployees(categoryId, searchQuery)
    }

    fun onSearchQueryChange(newQuery: String) {
        searchQuery = newQuery
        selectedCategoryId?.let { loadEmployees(it, newQuery) }
    }

    fun loadEmployees(categoryId: Int, searchValue: String? = null) {
        viewModelScope.launch {
            isLoading = true
            try {
                val cacheKey = categoryId to (searchValue ?: "")
                if (employeesCache.containsKey(cacheKey)) {
                    _employees.clear()
                    _employees.addAll(employeesCache[cacheKey]!!)
                } else {
                    val result = getEmployeesUseCase(categoryId = categoryId, searchValue = searchValue)
                    employeesCache[cacheKey] = result
                    _employees.clear()
                    _employees.addAll(result)
                }
            } catch (e: Exception) {
                Log.d("EmployeeViewModel", "Ошибка в EmployeeViewModel: ${e.message}")
            } finally {
                isLoading = false
            }
        }
    }
}
