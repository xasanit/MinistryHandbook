package com.example.ministryoffinance.data.fake

import com.example.ministryoffinance.domain.repository.EmployeeRepository
import com.example.ministryoffinance.domain.model.Employee
import com.example.ministryoffinance.data.fake.mock.mockEmployeeList
import com.example.ministryoffinance.data.fake.mock.sortByCategory

class FakeEmployeeRepositoryImpl: EmployeeRepository {

    override suspend fun getEmployees(
        page: Int?,
        limit: Int?,
        searchValue: String?,
        categoryId: Int?
    ): List<Employee> {
        return sortByCategory(mockEmployeeList, categoryId)
    }

    override suspend fun getEmployee(id: Int): Employee {
        var index = 0
        var i = -1
        for(employee in mockEmployeeList) {
            i++
            if(id == employee.id) {
                index = i
            }
        }
        return mockEmployeeList[index]
    }

    override suspend fun getPicture(id: String): ByteArray {
        return ByteArray(5)
    }
}