package com.example.ministryoffinance.ui.values.variables

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.ministryoffinance.R

object AppIcons {
    @Composable
    fun menuIcon() = painterResource(R.drawable.menu)

    @Composable
    fun phoneIcon() = painterResource(R.drawable.phone)

    @Composable
    fun emailIcon() = painterResource(R.drawable.email)

    @Composable
    fun roomIcon() = painterResource(R.drawable.building)

    @Composable
    fun searchIcon() = painterResource(R.drawable.search)

    @Composable
    fun backIcon() = painterResource(R.drawable.back_fill)
}
