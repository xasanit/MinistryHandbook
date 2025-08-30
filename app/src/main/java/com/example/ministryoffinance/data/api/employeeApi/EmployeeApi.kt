package com.example.ministryoffinance.data.api.employeeApi

import android.graphics.Bitmap
import com.example.ministryoffinance.data.dto.EmployeeDto
import com.example.ministryoffinance.data.dto.EmployeeListResponse

interface EmployeeApi {

    suspend fun getEmployees(
        page: Int? = null,
        limit: Int? = null,
        searchValue: String? = null,
        categoryId: Int?,
    ): EmployeeListResponse

    suspend fun getEmployee(id: Int): EmployeeDto

    suspend fun getPicture(id: String): Bitmap

}