package com.example.ministryoffinance.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ministryoffinance.ui.composables.screen.HomeScreen
import com.example.ministryoffinance.ui.composables.screen.ViewEmployeeDetails

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        composable(Screen.Home.route) {
            HomeScreen(onCardClick = { employeeId ->
                navController.navigate(Screen.Details.createRoute(employeeId))
            })
        }

        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument("employeeId") { type = NavType.IntType })
        ) { backStackEntry ->
            val employeeId = backStackEntry.arguments?.getInt("employeeId") ?: -1
            ViewEmployeeDetails(employeeId = employeeId, onBack = { navController.popBackStack() })
        }

    }
}