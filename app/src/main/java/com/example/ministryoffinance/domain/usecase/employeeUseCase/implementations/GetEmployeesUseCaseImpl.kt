package com.example.ministryoffinance.domain.usecase.employeeUseCase.implementations

import com.example.ministryoffinance.data.repository.employeeRepository.EmployeeRepository
import com.example.ministryoffinance.domain.model.Employee
import com.example.ministryoffinance.domain.usecase.employeeUseCase.interfaces.GetEmployeesUseCase

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