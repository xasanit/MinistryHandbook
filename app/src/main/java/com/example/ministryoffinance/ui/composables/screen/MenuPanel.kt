package com.example.ministryoffinance.ui.composables.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.ministryoffinance.domain.model.Category
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
    ) {
        Text("Категории", modifier = Modifier
            .padding(15.dp)
        )

        if (isLoading) {
            Box(
                modifier = Modifier
                .fillMaxSize()
                    .background(Color.Blue),
                contentAlignment =
                    Alignment.Center

            ) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn {
                items(categoryList) { item->
                    NavigationDrawerItem(
                        label = { Text(text = item.ruName) },
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