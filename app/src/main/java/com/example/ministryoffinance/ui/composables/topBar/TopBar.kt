package com.example.ministryoffinance.ui.composables.topBar

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ministryoffinance.ui.composables.screen.TitleRow
import com.example.ministryoffinance.ui.theme.OnPrimary
import com.example.ministryoffinance.ui.theme.Primary
import com.example.ministryoffinance.ui.theme.Secondary
import com.example.ministryoffinance.ui.values.variables.AppIcons
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: @Composable () -> Unit,
    scope: CoroutineScope,
    drawerState: DrawerState,
) {
    CenterAlignedTopAppBar(
        navigationIcon = {
            Icon(
                painter = AppIcons.menuIcon(),
                contentDescription = "Menu",
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .size(25.dp)
                    .clickable {
                        scope.launch { drawerState.open() }
                    }
            )
        },
        title = title,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Primary,
            titleContentColor = OnPrimary,
            navigationIconContentColor = OnPrimary
        ),
        modifier = Modifier
            .fillMaxWidth()
    )
}

@Preview
@Composable
fun TopBarPReview() {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    TopBar(
        title = { TitleRow() },
        scope = scope,
        drawerState = drawerState
    )
}