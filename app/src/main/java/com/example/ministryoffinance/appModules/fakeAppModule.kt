package com.example.ministryoffinance.appModules

import com.example.ministryoffinance.data.repository.categoryRepository.CategoryRepository
import com.example.ministryoffinance.data.repository.employeeRepository.EmployeeRepository
import com.example.ministryoffinance.domain.usecase.categoryUseCase.CategoriesUseCaseImpl
import com.example.ministryoffinance.domain.usecase.categoryUseCase.CategoryUseCase
import com.example.ministryoffinance.domain.usecase.employeeUseCase.implementations.GetEmployeeByIdUseCaseImpl
import com.example.ministryoffinance.domain.usecase.employeeUseCase.interfaces.GetEmployeesUseCase
import com.example.ministryoffinance.domain.usecase.employeeUseCase.implementations.GetEmployeesUseCaseImpl
import com.example.ministryoffinance.domain.usecase.employeeUseCase.interfaces.GetEmployeeByIdUseCase
import com.example.ministryoffinance.ui.values.mock.fakeRepository.FakeCategoryRepositoryImpl
import com.example.ministryoffinance.ui.values.mock.fakeRepository.FakeEmployeeRepositoryImpl
import com.example.ministryoffinance.ui.viewmodel.CategoryViewModel
import com.example.ministryoffinance.ui.viewmodel.EmployeeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val fakeAppModule = module {

    single<CategoryRepository> { FakeCategoryRepositoryImpl() }
    single<EmployeeRepository> { FakeEmployeeRepositoryImpl() }

    single<CategoryUseCase> { CategoriesUseCaseImpl(get()) }
    single<GetEmployeesUseCase> { GetEmployeesUseCaseImpl(get()) }
    single<GetEmployeeByIdUseCase> { GetEmployeeByIdUseCaseImpl(get()) }

    viewModel { CategoryViewModel(get()) }
    viewModel { EmployeeViewModel(
        employeeUseCase = get(),
        getEmployeeByIdUseCase = get()
    ) }

}