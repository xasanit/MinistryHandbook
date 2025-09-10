package com.example.ministryoffinance.ui.composables.topBar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ministryoffinance.ui.values.variables.AppIcons

@Composable
fun BackIcon(
    navController: NavController
) {
    Box(
        contentAlignment = Alignment.Center
    ) {
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
    }


}