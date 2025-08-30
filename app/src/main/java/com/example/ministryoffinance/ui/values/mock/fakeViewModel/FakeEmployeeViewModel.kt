package com.example.ministryoffinance.ui.values.mock.fakeViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ministryoffinance.ui.values.mock.fakeUseCase.FakeGetEmployeesUseCase
import com.example.ministryoffinance.domain.model.Employee
import kotlinx.coroutines.launch

class FakeEmployeeViewModel (
    val useCase: FakeGetEmployeesUseCase
): ViewModel() {

    val employeeList = mutableListOf<Employee>()

    var isLoading by mutableStateOf(false)
        private set

    var selectedCategoryId: Int? by mutableStateOf(1)
        private set

    fun loadEmployees(categoryId: Int) {
        viewModelScope.launch {
            val result = useCase(categoryId = categoryId)
            employeeList.addAll(result)
        }
    }
}