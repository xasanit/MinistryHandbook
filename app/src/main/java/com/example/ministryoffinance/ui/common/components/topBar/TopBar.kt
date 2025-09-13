package com.example.ministryoffinance.ui.common.components.topBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.ministryoffinance.ui.common.theme.OnPrimary
import com.example.ministryoffinance.ui.common.theme.Primary

@Composable
fun TopBar(
    icon: @Composable () -> Unit,
) {
    CompositionLocalProvider(LocalContentColor provides OnPrimary) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Primary)
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            icon()
            TitleRow()
        }
    }
}


@Preview
@Composable
fun TopBarPreview() {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    TopBar(
        icon = { MenuIcon(scope = scope, drawerState = drawerState) },
    )
}

@Preview
@Composable
fun BaseTopBarPreview() {
    val navController = rememberNavController()
    TopBar(
        icon = { BackIcon(navController = navController) },
    )

}