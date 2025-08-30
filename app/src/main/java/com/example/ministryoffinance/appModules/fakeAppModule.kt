package com.example.ministryoffinance.appModules

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ministryoffinance.ui.values.mock.fakeUseCase.FakeGetCategoriesUseCase
import com.example.ministryoffinance.ui.values.mock.fakeUseCase.FakeGetEmployeesUseCase
import com.example.ministryoffinance.ui.values.mock.fakeViewModel.FakeCategoryViewModel
import com.example.ministryoffinance.ui.values.mock.fakeViewModel.FakeEmployeeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val fakeAppModule = module {

    single<FakeGetCategoriesUseCase>{ get() }
    single<FakeGetEmployeesUseCase>{ get() }

    viewModel{ FakeCategoryViewModel(get()) }
    viewModel{ FakeEmployeeViewModel(get()) }

}