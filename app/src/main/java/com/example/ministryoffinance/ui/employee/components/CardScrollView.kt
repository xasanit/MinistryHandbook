package com.example.ministryoffinance.ui.employee.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ministryoffinance.domain.model.Employee
import com.example.ministryoffinance.domain.usecase.employeeUseCase.GetEmployeeByIdUseCaseImpl
import com.example.ministryoffinance.domain.usecase.employeeUseCase.GetEmployeesUseCaseImpl
import com.example.ministryoffinance.data.fake.FakeEmployeeRepositoryImpl
import com.example.ministryoffinance.ui.employee.EmployeeViewModel

@Composable
fun CardScrollView (
    employeeList: List<Employee>,
    isLoading: Boolean,
    onEmployeeClick: (Int) -> Unit
) {

    if (isLoading) {

        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            items(employeeList) { employee ->
                EmployeeCard(
                    employee,
                    onClick = { onEmployeeClick(employee.id) },
                )
            }
        }
    }
}

@Preview
@Composable
fun CardScrollPreview() {

    val employeeRepo = FakeEmployeeRepositoryImpl()

    val employeeUseCase = GetEmployeesUseCaseImpl(employeeRepo)

    val employeeByIdUseCase = GetEmployeeByIdUseCaseImpl(employeeRepo)

    val employeeVM = EmployeeViewModel(employeeUseCase, employeeByIdUseCase)

    CardScrollView(
        employeeList = employeeVM.employees,
        isLoading = false
    ) {}

}