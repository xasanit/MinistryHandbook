package com.example.ministryoffinance.ui.values.mock.fakeUseCase

import com.example.ministryoffinance.ui.values.mock.data.mockEmployeeList
import com.example.ministryoffinance.domain.model.Employee

class FakeGetEmployeesUseCase {
    suspend operator fun invoke(
        categoryId: Int
    ): List<Employee> {
        val result = mutableListOf<Employee>()
        for (employee in mockEmployeeList) {
            if (employee.categoryId == categoryId) {
                result.add(employee)
            }
        }
        return result
    }
}