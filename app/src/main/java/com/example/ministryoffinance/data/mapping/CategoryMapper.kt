package com.example.ministryoffinance.data.mapping

import com.example.ministryoffinance.data.dto.CategoryDto
import com.example.ministryoffinance.domain.model.Category

fun CategoryDto.toDomain(): Category {
    return Category (
        id = id,
        kgName = kgName,
        ruName = ruName,
    )
}