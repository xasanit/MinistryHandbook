package com.example.ministryoffinance.ui.navigation

sealed class Screen (
    val route: String
) {
    object HomeScreen: Screen("home")
    object DetailsScreen: Screen("details/{employeeId}") {
        fun createRoute(employeeId: Int) = "details/${employeeId}"
    }
}