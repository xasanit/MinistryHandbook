package com.example.ministryoffinance.appModules

import com.example.ministryoffinance.data.api.categoryApi.CategoryApi
import com.example.ministryoffinance.data.api.categoryApi.CategoryApiImpl
import com.example.ministryoffinance.data.api.employeeApi.EmployeeApi
import com.example.ministryoffinance.data.api.employeeApi.EmployeeApiImpl
import com.example.ministryoffinance.data.repository.categoryRepository.CategoryRepository
import com.example.ministryoffinance.data.repository.categoryRepository.CategoryRepositoryImpl
import com.example.ministryoffinance.data.repository.employeeRepository.EmployeeRepository
import com.example.ministryoffinance.data.repository.employeeRepository.EmployeeRepositoryImpl
import com.example.ministryoffinance.domain.usecase.categoryUseCase.CategoriesUseCaseImpl
import com.example.ministryoffinance.domain.usecase.categoryUseCase.CategoryUseCase
import com.example.ministryoffinance.domain.usecase.employeeUseCase.implementations.GetEmployeeByIdUseCaseImpl
import com.example.ministryoffinance.domain.usecase.employeeUseCase.interfaces.GetEmployeesUseCase
import com.example.ministryoffinance.domain.usecase.employeeUseCase.implementations.GetEmployeesUseCaseImpl
import com.example.ministryoffinance.domain.usecase.employeeUseCase.interfaces.GetEmployeeByIdUseCase
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

    single<GetEmployeesUseCase> { GetEmployeesUseCaseImpl(get()) }
    single<GetEmployeeByIdUseCase> { GetEmployeeByIdUseCaseImpl(get()) }

    single<CategoryUseCase> { CategoriesUseCaseImpl(get()) }




    viewModel { EmployeeViewModel(
        employeeUseCase = get(),
        getEmployeeByIdUseCase = get()
    ) }
    viewModel { CategoryViewModel(get()) }

}