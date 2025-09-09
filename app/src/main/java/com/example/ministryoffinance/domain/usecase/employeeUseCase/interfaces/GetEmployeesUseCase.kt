package com.example.ministryoffinance.domain.usecase.employeeUseCase.interfaces

import com.example.ministryoffinance.domain.model.Employee

interface GetEmployeesUseCase {
    suspend fun getEmployeesUseCase(
        page: Int? = null,
        limit: Int? = null,
        searchValue: String? = null,
        categoryId: Int? = null,
    ): List<Employee>
}