package com.example.ministryoffinance.data.repository.employeeRepository

import com.example.ministryoffinance.data.api.employeeApi.EmployeeApi
import com.example.ministryoffinance.data.mapping.toDomain
import com.example.ministryoffinance.domain.model.Employee

class EmployeeRepositoryImpl (
    val api: EmployeeApi
): EmployeeRepository {

    override suspend fun getEmployees(
        page: Int?,
        limit: Int?,
        searchValue: String?,
        categoryId: Int?
    ): List<Employee> {
        val response = api.getEmployees(page, limit, searchValue, categoryId)
        return response.rows.map {it.toDomain()}
    }

    override suspend fun getEmployee(id: Int): Employee {
        return api.getEmployee(id).toDomain()
    }

    override suspend fun getPicture(id: String) = api.getPicture(id)
}