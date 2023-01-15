package com.shushant.chattiez.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.shushant.navigation.AppComposeNavigator
import com.shushant.navigation.ChattiezScreens

@Composable
fun ChattiezNavHost(
    navHostController: NavHostController,
    composeNavigator: AppComposeNavigator
) {
    NavHost(
        navController = navHostController,
        startDestination = ChattiezScreens.Splash.route
    ) {
        chattiezSplash(
            composeNavigator = composeNavigator
        )
        chattiezOnBoarding(
            composeNavigator = composeNavigator
        )
    }
}
