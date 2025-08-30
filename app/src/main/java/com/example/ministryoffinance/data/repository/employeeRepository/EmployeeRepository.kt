package com.example.ministryoffinance.data.repository.employeeRepository

import android.graphics.Bitmap
import com.example.ministryoffinance.domain.model.Employee

interface EmployeeRepository {

    suspend fun getEmployees(
        page: Int? = null,
        limit: Int? = null,
        searchValue: String? = null,
        categoryId: Int? = null,
    ): List<Employee>

    suspend fun getEmployee(id: Int): Employee

    suspend fun getPicture(id: String): Bitmap

}