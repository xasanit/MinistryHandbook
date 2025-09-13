package com.example.ministryoffinance.di

import com.example.ministryoffinance.domain.repository.CategoryRepository
import com.example.ministryoffinance.domain.repository.EmployeeRepository
import com.example.ministryoffinance.domain.usecase.categoryUseCase.CategoriesUseCaseImpl
import com.example.ministryoffinance.domain.usecase.categoryUseCase.CategoryUseCase
import com.example.ministryoffinance.domain.usecase.employeeUseCase.GetEmployeeByIdUseCaseImpl
import com.example.ministryoffinance.domain.usecase.employeeUseCase.GetEmployeesUseCase
import com.example.ministryoffinance.domain.usecase.employeeUseCase.GetEmployeesUseCaseImpl
import com.example.ministryoffinance.domain.usecase.employeeUseCase.GetEmployeeByIdUseCase
import com.example.ministryoffinance.data.fake.FakeCategoryRepositoryImpl
import com.example.ministryoffinance.data.fake.FakeEmployeeRepositoryImpl
import com.example.ministryoffinance.ui.category.CategoryViewModel
import com.example.ministryoffinance.ui.employee.EmployeeViewModel
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