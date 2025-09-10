package com.example.ministryoffinance.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ministryoffinance.domain.usecase.employeeUseCase.implementations.GetEmployeeByIdUseCaseImpl
import com.example.ministryoffinance.domain.usecase.employeeUseCase.implementations.GetEmployeesUseCaseImpl
import com.example.ministryoffinance.ui.composables.EmployeeDetails
import com.example.ministryoffinance.ui.composables.topBar.BackIcon
import com.example.ministryoffinance.ui.composables.topBar.TopBar
import com.example.ministryoffinance.ui.values.mock.fakeRepository.FakeEmployeeRepositoryImpl
import com.example.ministryoffinance.ui.viewmodel.EmployeeUiState
import com.example.ministryoffinance.ui.viewmodel.EmployeeViewModel

@Composable
fun DetailsScreen(
    employeeId: Int,
    viewModel: EmployeeViewModel,
    navController: NavController
) {
    // Загружаем сотрудника при первом входе на экран
    LaunchedEffect(employeeId) {
        viewModel.loadEmployeeById(employeeId)
    }

    val state by viewModel.employeeState.collectAsState()

    Column {
        TopBar(
            icon = { BackIcon(navController) },
        )
        Box(
            modifier = Modifier
                .padding(top = 15.dp)
                .fillMaxSize()
        ) {
            when (state) {
                is EmployeeUiState.Loading -> Text(text = "Loading...")
                is EmployeeUiState.Error -> Text((state as EmployeeUiState.Error).message)
                is EmployeeUiState.Success ->
                    EmployeeDetails(
                        employee = (state as EmployeeUiState.Success).employee
                    )
            }
        }

    }
}

@Preview
@Composable
fun DetailsScreenPreview(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    val employeeRepo = FakeEmployeeRepositoryImpl()

    val employeeUseCase = GetEmployeesUseCaseImpl(employeeRepo)

    val employeeByIdUseCase = GetEmployeeByIdUseCaseImpl(employeeRepo)

    val employeeVM = EmployeeViewModel(employeeUseCase, employeeByIdUseCase)

    DetailsScreen(
        employeeId = 1,
        viewModel = employeeVM,
        navController = navController
    )

}
