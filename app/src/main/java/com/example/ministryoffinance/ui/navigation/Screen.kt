package com.example.ministryoffinance.ui.navigation

sealed class Screen (
    val route: String
) {
    object Home: Screen("home")
    object Details: Screen("details/{employeeId}") {
        fun createRoute(employeeId: Int) = "details/$employeeId"
    }
}