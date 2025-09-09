package com.example.ministryoffinance.domain.usecase.employeeUseCase.implementations

import com.example.ministryoffinance.data.repository.employeeRepository.EmployeeRepository
import com.example.ministryoffinance.domain.model.Employee
import com.example.ministryoffinance.domain.usecase.employeeUseCase.interfaces.GetEmployeeByIdUseCase

class GetEmployeeByIdUseCaseImpl(
    val repository: EmployeeRepository
): GetEmployeeByIdUseCase {
    override suspend fun getEmployeeById(employeeId: Int): Employee {
        return repository.getEmployee(id = employeeId)
    }
}