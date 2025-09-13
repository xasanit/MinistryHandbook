package com.example.ministryoffinance.ui.common.components.topBar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ministryoffinance.ui.common.resources.appIcons.AppIcons
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun MenuIcon(
    scope: CoroutineScope,
    drawerState: DrawerState
) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = AppIcons.menuIcon(),
            contentDescription = "Menu",
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .size(25.dp)
                .clickable {
                    scope.launch { drawerState.open() }
                },
        )
    }
}