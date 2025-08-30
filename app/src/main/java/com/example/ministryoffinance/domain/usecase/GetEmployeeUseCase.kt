package com.example.ministryoffinance.domain.usecase

import com.example.ministryoffinance.data.repository.employeeRepository.EmployeeRepository
import com.example.ministryoffinance.domain.model.Employee

class GetEmployeeUseCase (
    val repository: EmployeeRepository,
) {
    suspend operator fun invoke(
        id: Int
    ): Employee {
        return repository.getEmployee(id = id)
    }
}