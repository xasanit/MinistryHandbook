package com.example.ministryoffinance.data.api.employeeApi

import android.graphics.Bitmap
import com.example.ministryoffinance.data.dto.EmployeeDto
import com.example.ministryoffinance.data.dto.EmployeeListResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class EmployeeApiImpl (
    private val client: HttpClient,
    private val baseUrl: String,
): EmployeeApi {

    override suspend fun getEmployees(
        page: Int?,
        limit: Int?,
        searchValue: String?,
        categoryId: Int?
    ): EmployeeListResponse {
        return client.get ("$baseUrl/employee/") {
            parameter("page", page)
            parameter("limit", limit)
            searchValue?.let { parameter("searchValue", it) }
            categoryId?.let { parameter("categoryId", it) }
        }.body()
    }

    override suspend fun getEmployee(
        id: Int
    ): EmployeeDto {
        return client.get ("$baseUrl/employee/$id").body()
    }

    override suspend fun getPicture(
        id: String
    ): Bitmap {
        return client.get("$baseUrl/employee/picture/$id").body()
    }
}