package com.example.ministryoffinance.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ministryoffinance.ui.screen.DetailsScreen
import com.example.ministryoffinance.ui.screen.HomeScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(
                navController = navController,
                modifier = Modifier,
                employeeViewModel = koinViewModel(),
                categoryViewModel = koinViewModel(),
            )
        }
        composable(
            route = Screen.DetailsScreen.route,
            arguments = listOf(navArgument("employeeId") {
                type = NavType.IntType
            })
        ) { backStackEntry ->
            val employeeId = backStackEntry.arguments?.getInt("employeeId") ?: -1
            DetailsScreen(employeeId = employeeId, viewModel = koinViewModel(), navController)
        }
    }
}
