package com.example.ministryoffinance.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ministryoffinance.domain.model.Category
import com.example.ministryoffinance.domain.usecase.categoryUseCase.CategoriesUseCaseImpl
import com.example.ministryoffinance.ui.theme.OnPrimary
import com.example.ministryoffinance.ui.theme.Primary
import com.example.ministryoffinance.ui.values.mock.fakeRepository.FakeCategoryRepositoryImpl
import com.example.ministryoffinance.ui.viewmodel.CategoryViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationMenu(
    viewModel: CategoryViewModel,
    isLoading: Boolean,
    onCategorySelected: (Int) -> Unit
) {
    val categoryList: List<Category> = viewModel.categories

    ModalDrawerSheet(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(0.7f)
            .border(width = 2.dp, color = Primary),
        drawerShape = RectangleShape,
        drawerContainerColor = OnPrimary,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(color = Primary)

        ) {
            Text(
                "Категории", modifier = Modifier
                    .padding(15.dp),
                fontSize = 20.sp,
                fontWeight = Bold,
                color = OnPrimary
            )
        }

        if (isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(OnPrimary),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .background(OnPrimary)
            ) {
                items(categoryList) { item ->
                    NavigationDrawerItem(
                        label = {
                            Text(
                                text = item.ruName,
                                fontSize = 16.sp,
                                fontWeight = Medium,
                                color = Primary
                            )
                        },
                        selected = false,
                        onClick = {
                            onCategorySelected(item.id)
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun NavigationMenuPreview() {

    val categoryRepo = FakeCategoryRepositoryImpl()

    val categoryUseCase = CategoriesUseCaseImpl(categoryRepo)

    val categoryVM = CategoryViewModel(categoryUseCase)

    NavigationMenu(
        viewModel = categoryVM,
        isLoading = false
    ) { }
}