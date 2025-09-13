package com.example.ministryoffinance.domain.usecase.employeeUseCase

import com.example.ministryoffinance.domain.repository.EmployeeRepository
import com.example.ministryoffinance.domain.model.Employee

class GetEmployeesUseCaseImpl (
    val repository: EmployeeRepository
): GetEmployeesUseCase {
    override suspend fun getEmployeesUseCase(
        page: Int?,
        limit: Int?,
        searchValue: String?,
        categoryId: Int?
    ): List<Employee> {
        return repository.getEmployees(page, limit, searchValue = searchValue, categoryId = categoryId)
    }
}