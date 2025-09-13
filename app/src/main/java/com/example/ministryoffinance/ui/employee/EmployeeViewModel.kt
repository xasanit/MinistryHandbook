package com.example.ministryoffinance.ui.employee

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ministryoffinance.domain.model.Employee
import com.example.ministryoffinance.domain.usecase.employeeUseCase.GetEmployeeByIdUseCase
import com.example.ministryoffinance.domain.usecase.employeeUseCase.GetEmployeesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class EmployeeUiState {
    object Loading: EmployeeUiState()
    data class Success(val employee: Employee): EmployeeUiState()
    data class Error(val message: String): EmployeeUiState()
}


class EmployeeViewModel(
    private val employeeUseCase: GetEmployeesUseCase,
    private val getEmployeeByIdUseCase: GetEmployeeByIdUseCase
) : ViewModel() {

    private val employeesCache = mutableMapOf<Pair<Int, String>, List<Employee>>() // ключ: categoryId + search

    private val _employees = mutableStateListOf<Employee>()
    val employees: List<Employee> get() = _employees

    private val _employeeState = MutableStateFlow<EmployeeUiState>(EmployeeUiState.Loading)
    var employeeState: StateFlow<EmployeeUiState> = _employeeState

    var isLoading by mutableStateOf(false)
        private set

    var searchQuery by mutableStateOf("")
        private set

    var selectedCategoryId: Int? by mutableStateOf(-1)
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
                    val result = employeeUseCase.getEmployeesUseCase(categoryId = categoryId, searchValue = searchValue)
                    employeesCache[cacheKey] = result
                    _employees.clear()
                    _employees.addAll(result)
                }
            } catch (e: Exception) {
                Log.d("EmployeeViewModel", "Ошибка в loadEmployees: ${e.message}")
            } finally {
                isLoading = false
            }
        }
    }

    fun loadEmployeeById(id: Int) {
        viewModelScope.launch {
            isLoading = true
            try {
                val result = getEmployeeByIdUseCase.getEmployeeById(id)
                _employeeState.value = EmployeeUiState.Success(result)
            } catch (e: Exception) {
                Log.d("EmployeeViewModel", "Ошибка в loadEmployeeById: ${e.message}")
            } finally {
                isLoading = false
            }
        }
    }
}
