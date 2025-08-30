package com.example.ministryoffinance.data.mapping

import com.example.ministryoffinance.data.dto.EmployeeDto
import com.example.ministryoffinance.domain.model.Employee

fun EmployeeDto.toDomain(): Employee {
    return Employee(
        id = id,
        fullName = "$lastName $firstName $middleName",
        position = position,
        landlineNumber = landlineNumber,
        extensionNumber = extensionNumber,
        email = email,
        room = room,
        categoryId = categoryId,
        image = image,
    )
}