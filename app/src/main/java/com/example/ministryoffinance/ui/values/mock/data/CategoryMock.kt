package com.example.ministryoffinance.ui.values.mock.data

import com.example.ministryoffinance.domain.model.Category


val category5 = Category(
    id = 5,
    kgName = "Финанс отделы",
    ruName = "Отдел финансов"
)

val category6 = Category(
    id = 6,
    kgName = "Информациялык технологиялар отделы",
    ruName = "Отдел информационных технологий"
)

val category7 = Category(
    id = 7,
    kgName = "Бухгалтерия отделы",
    ruName = "Отдел бухгалтерии"
)

val mockCategoryList = listOf(category5, category6, category7)

