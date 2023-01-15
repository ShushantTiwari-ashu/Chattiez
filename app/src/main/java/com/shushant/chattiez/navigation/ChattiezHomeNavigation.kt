package com.shushant.chattiez.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.shushant.chattiez.splash.ui.SplashScreen
import com.shushant.chattiez.splash.ui.boarding.OnBoarding
import com.shushant.navigation.AppComposeNavigator
import com.shushant.navigation.ChattiezScreens

fun NavGraphBuilder.chattiezSplash(
    composeNavigator: AppComposeNavigator
) {
    composable(route = ChattiezScreens.Splash.name) {
        SplashScreen(composeNavigator = composeNavigator)
    }
}

fun NavGraphBuilder.chattiezOnBoarding(
    composeNavigator: AppComposeNavigator
) {
    composable(route = ChattiezScreens.Splash.name) {
        OnBoarding(composeNavigator = composeNavigator)
    }
}