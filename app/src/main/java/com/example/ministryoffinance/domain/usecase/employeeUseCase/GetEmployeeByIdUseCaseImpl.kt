package com.example.ministryoffinance.domain.usecase.employeeUseCase

import com.example.ministryoffinance.domain.repository.EmployeeRepository
import com.example.ministryoffinance.domain.model.Employee

class GetEmployeeByIdUseCaseImpl(
    val repository: EmployeeRepository
): GetEmployeeByIdUseCase {
    override suspend fun getEmployeeById(employeeId: Int): Employee {
        return repository.getEmployee(id = employeeId)
    }
}