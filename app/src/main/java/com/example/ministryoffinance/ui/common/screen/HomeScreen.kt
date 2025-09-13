package com.example.ministryoffinance.ui.common.screen

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
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ministryoffinance.domain.usecase.categoryUseCase.CategoriesUseCaseImpl
import com.example.ministryoffinance.domain.usecase.employeeUseCase.GetEmployeeByIdUseCaseImpl
import com.example.ministryoffinance.domain.usecase.employeeUseCase.GetEmployeesUseCaseImpl
import com.example.ministryoffinance.ui.employee.components.EmployeeSearchBar
import com.example.ministryoffinance.ui.employee.components.CardScrollView
import com.example.ministryoffinance.ui.common.components.topBar.MenuIcon
import com.example.ministryoffinance.ui.common.components.topBar.TopBar
import com.example.ministryoffinance.ui.category.NavigationMenu
import com.example.ministryoffinance.data.fake.FakeCategoryRepositoryImpl
import com.example.ministryoffinance.data.fake.FakeEmployeeRepositoryImpl
import com.example.ministryoffinance.ui.category.CategoryViewModel
import com.example.ministryoffinance.ui.common.navigation.Screen
import com.example.ministryoffinance.ui.employee.EmployeeViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    employeeViewModel: EmployeeViewModel = koinViewModel(),
    categoryViewModel: CategoryViewModel = koinViewModel(),
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
                icon = { MenuIcon(scope = scope, drawerState = drawerState) }
            )

            Spacer(modifier = Modifier.height(10.dp))

            EmployeeSearchBar(
                query = employeeViewModel.searchQuery,
                onQueryChange = { newQuery ->
                    employeeViewModel.onSearchQueryChange(newQuery)
                }
            )

            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = selectedCategory?.ruName ?: "Категория не выбрана",
                    fontWeight = Medium,
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(10.dp))

                CardScrollView(
                    employeeList = employeeViewModel.employees,
                    isLoading = employeeViewModel.isLoading,
                    onEmployeeClick = { employeeId ->
                        navController.navigate(Screen.DetailsScreen.createRoute(employeeId))
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {

    val navController = rememberNavController()

    val categoryRepo = FakeCategoryRepositoryImpl()

    val categoryUseCase = CategoriesUseCaseImpl(categoryRepo)

    val categoryVM = CategoryViewModel(categoryUseCase)

    val employeeRepo = FakeEmployeeRepositoryImpl()

    val employeeUseCase = GetEmployeesUseCaseImpl(employeeRepo)

    val employeeByIdUseCase = GetEmployeeByIdUseCaseImpl(employeeRepo)

    val employeeVM = EmployeeViewModel(employeeUseCase, employeeByIdUseCase)

    HomeScreen(
        navController = navController,
        modifier = Modifier,
        employeeViewModel = employeeVM,
        categoryViewModel = categoryVM,
    )
}