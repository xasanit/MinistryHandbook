package com.example.ministryoffinance.domain.repository

import com.example.ministryoffinance.domain.model.Employee

interface EmployeeRepository {

    suspend fun getEmployees(
        page: Int? = null,
        limit: Int? = null,
        searchValue: String? = null,
        categoryId: Int? = null,
    ): List<Employee>

    suspend fun getEmployee(id: Int): Employee

    suspend fun getPicture(id: String): ByteArray

}