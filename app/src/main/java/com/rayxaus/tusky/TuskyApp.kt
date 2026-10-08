package com.rayxaus.tusky

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.rayxaus.tusky.navigation.ScreenOneRoute
import com.rayxaus.tusky.navigation.ScreenTwoRoute
import com.rayxaus.tusky.navigation.navigationItems
import com.rayxaus.tusky.ui.screenOne.ScreenOne
import com.rayxaus.tusky.ui.screenTwo.ScreenTwo

@Composable
fun TuskyApp() {
    val navController = rememberNavController()
    val backStackState = navController.currentBackStackEntryAsState()

    Scaffold(
        bottomBar = {
            NavigationBar {
                navigationItems.forEach { item ->
                    NavigationBarItem(
                        selected = backStackState.value?.destination?.hasRoute(item.route::class) == true,
                        icon = { Icon(painter = painterResource(item.icon), contentDescription = null) },
                        label = { Text(text = item.name) },
                        onClick = { navController.navigate(item.route) }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            modifier = Modifier
                .padding(bottom = innerPadding.calculateBottomPadding())
                .consumeWindowInsets(WindowInsets.navigationBars),
            navController = navController,
            startDestination = ScreenOneRoute
        ) {
            composable<ScreenOneRoute> { ScreenOne() }
            composable<ScreenTwoRoute> { ScreenTwo() }
        }
    }
}