package com.example.ministryoffinance.data.api.categoryApi

import android.util.Log
import com.example.ministryoffinance.data.dto.CategoryDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class CategoryApiImpl (
    private val client: HttpClient,
    private val baseUrl: String,
): CategoryApi {

    override suspend fun getCategories(): List<CategoryDto> {
        return client.get ("$baseUrl/category").body()
    }


    override suspend fun getCategory(
        id: Int
    ): CategoryDto {
        return client.get ("$baseUrl/category/$id").body()
    }
}