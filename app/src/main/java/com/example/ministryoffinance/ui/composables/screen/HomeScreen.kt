package com.example.ministryoffinance.ui.composables.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ministryoffinance.ui.composables.employee.CardScrollView
import com.example.ministryoffinance.ui.composables.employee.EmployeeSearchBar
import com.example.ministryoffinance.ui.viewmodel.CategoryViewModel
import com.example.ministryoffinance.ui.viewmodel.EmployeeViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    employeeViewModel: EmployeeViewModel = koinViewModel(),
    categoryViewModel: CategoryViewModel = koinViewModel(),
    onCardClick: (Int) -> Unit,
    ) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    // Получаем список категорий при старте
    LaunchedEffect(Unit) {
        categoryViewModel.getCategories()
    }

    val selectedCategory = categoryViewModel.categories.firstOrNull {
        it.id == employeeViewModel.selectedCategoryId
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            NavigationMenu(
                viewModel = categoryViewModel,
                isLoading = categoryViewModel.isLoading
            ) { categoryId ->
                employeeViewModel.onCategorySelected(categoryId)
                scope.launch { drawerState.close() }
            }
        }
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
        ) {
            TopBar(
                title = { TitleRow() },
                scope = scope,
                drawerState = drawerState,
            )

            Spacer(modifier = Modifier.height(10.dp))

            EmployeeSearchBar(
                query = employeeViewModel.searchQuery,
                onQueryChange = { newQuery ->
                    employeeViewModel.onSearchQueryChange(newQuery)
                }
            )

            Column(modifier = Modifier.padding(horizontal = 20.dp)) {
                Spacer(modifier = Modifier.height(10.dp))

                // Название выбранной категории
                Text(
                    text = selectedCategory?.ruName ?: "Категория не выбрана",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(10.dp))

                CardScrollView(
                    employeeList = employeeViewModel.employees,
                    isLoading = employeeViewModel.isLoading
                )
            }
        }
    }
}