package com.example.ministryoffinance.ui.composables.topBar

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ministryoffinance.R
import com.example.ministryoffinance.ui.composables.screen.TitleRow
import com.example.ministryoffinance.ui.theme.OnPrimary
import com.example.ministryoffinance.ui.theme.Primary
import com.example.ministryoffinance.ui.values.variables.AppIcons

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseTopBar(
    navController: NavController
) {
    CenterAlignedTopAppBar(
        navigationIcon = {
            Icon(
                painter = AppIcons.backIcon(),
                contentDescription = "back",
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .size(25.dp)
                    .clickable {
                        navController.popBackStack()
                    }
            )
        },
        title = { TitleRow() },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Primary,
            titleContentColor = OnPrimary,
            navigationIconContentColor = OnPrimary
        ),
        modifier = Modifier
            .fillMaxWidth()
    )
}