package com.example.ministryoffinance.di

import com.example.ministryoffinance.data.api.CategoryApi
import com.example.ministryoffinance.data.api.CategoryApiImpl
import com.example.ministryoffinance.data.api.EmployeeApi
import com.example.ministryoffinance.data.api.EmployeeApiImpl
import com.example.ministryoffinance.domain.repository.CategoryRepository
import com.example.ministryoffinance.data.repository.CategoryRepositoryImpl
import com.example.ministryoffinance.domain.repository.EmployeeRepository
import com.example.ministryoffinance.data.repository.EmployeeRepositoryImpl
import com.example.ministryoffinance.domain.usecase.categoryUseCase.CategoriesUseCaseImpl
import com.example.ministryoffinance.domain.usecase.categoryUseCase.CategoryUseCase
import com.example.ministryoffinance.domain.usecase.employeeUseCase.GetEmployeeByIdUseCaseImpl
import com.example.ministryoffinance.domain.usecase.employeeUseCase.GetEmployeesUseCase
import com.example.ministryoffinance.domain.usecase.employeeUseCase.GetEmployeesUseCaseImpl
import com.example.ministryoffinance.domain.usecase.employeeUseCase.GetEmployeeByIdUseCase
import com.example.ministryoffinance.ui.category.CategoryViewModel
import com.example.ministryoffinance.ui.employee.EmployeeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {

    single<EmployeeApi> { EmployeeApiImpl(get(), get(named("baseUrl"))) }
    single<CategoryApi> { CategoryApiImpl(get(), get(named("baseUrl"))) }

    single<EmployeeRepository> { EmployeeRepositoryImpl(get()) }
    single<CategoryRepository> { CategoryRepositoryImpl(get()) }

    single<GetEmployeesUseCase> { GetEmployeesUseCaseImpl(get()) }
    single<GetEmployeeByIdUseCase> { GetEmployeeByIdUseCaseImpl(get()) }

    single<CategoryUseCase> { CategoriesUseCaseImpl(get()) }




    viewModel { EmployeeViewModel(
        employeeUseCase = get(),
        getEmployeeByIdUseCase = get()
    ) }
    viewModel { CategoryViewModel(get()) }

}