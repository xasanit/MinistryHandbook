package com.example.ministryoffinance.domain.usecase

import com.example.ministryoffinance.data.repository.employeeRepository.EmployeeRepository
import com.example.ministryoffinance.domain.model.Employee

class GetEmployeesUseCase (
    val repository: EmployeeRepository
) {
    suspend operator fun invoke(
        page: Int? = null,
        limit: Int? = null,
        searchValue: String? = null,
        categoryId: Int? = null,
    ): List<Employee> {
        return repository.getEmployees(page, limit, searchValue = searchValue, categoryId = categoryId)
    }
}