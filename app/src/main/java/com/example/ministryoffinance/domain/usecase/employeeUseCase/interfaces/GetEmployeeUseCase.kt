package com.example.ministryoffinance.domain.usecase.employeeUseCase.interfaces

import com.example.ministryoffinance.domain.model.Employee

interface GetEmployeeByIdUseCase {
    suspend fun getEmployeeById(
        employeeId: Int,
    ): Employee
}