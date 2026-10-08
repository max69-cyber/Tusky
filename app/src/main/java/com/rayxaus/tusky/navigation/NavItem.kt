package com.rayxaus.tusky.navigation

import androidx.annotation.DrawableRes
import com.rayxaus.tusky.R

data class NavItem(
    val name: String,
    val route: Any,
    @DrawableRes
    val icon: Int
)

val navigationItems = listOf(
    NavItem("Screen One", ScreenOneRoute, R.drawable.ic_looks_one),
    NavItem("Screen Two", ScreenTwoRoute, R.drawable.ic_looks_two)
)