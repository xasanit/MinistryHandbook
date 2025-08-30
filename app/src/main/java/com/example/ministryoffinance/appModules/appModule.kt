package com.example.ministryoffinance.appModules

import com.example.ministryoffinance.data.api.categoryApi.CategoryApi
import com.example.ministryoffinance.data.api.categoryApi.CategoryApiImpl
import com.example.ministryoffinance.data.api.employeeApi.EmployeeApi
import com.example.ministryoffinance.data.api.employeeApi.EmployeeApiImpl
import com.example.ministryoffinance.data.repository.categoryRepository.CategoryRepository
import com.example.ministryoffinance.data.repository.categoryRepository.CategoryRepositoryImpl
import com.example.ministryoffinance.data.repository.employeeRepository.EmployeeRepository
import com.example.ministryoffinance.data.repository.employeeRepository.EmployeeRepositoryImpl
import com.example.ministryoffinance.domain.usecase.GetCategoriesUseCase
import com.example.ministryoffinance.domain.usecase.GetEmployeesUseCase
import com.example.ministryoffinance.ui.viewmodel.CategoryViewModel
import com.example.ministryoffinance.ui.viewmodel.EmployeeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {

    single<EmployeeApi> { EmployeeApiImpl(get(), get(named("baseUrl"))) }
    single<CategoryApi> { CategoryApiImpl(get(), get(named("baseUrl"))) }

    single<EmployeeRepository> { EmployeeRepositoryImpl(get()) }
    single<CategoryRepository> { CategoryRepositoryImpl(get()) }

    single { GetEmployeesUseCase(get()) }
    single { GetCategoriesUseCase(get()) }

    viewModel { EmployeeViewModel(get()) }
    viewModel { CategoryViewModel(get()) }

}