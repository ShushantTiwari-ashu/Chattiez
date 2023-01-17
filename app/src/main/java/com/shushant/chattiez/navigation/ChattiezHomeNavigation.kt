package com.shushant.chattiez.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.shushant.chattiez.auth.AuthScreen
import com.shushant.chattiez.auth.login.LoginScreen
import com.shushant.chattiez.splash.ui.SplashScreen
import com.shushant.chattiez.splash.boarding.OnBoarding
import com.shushant.navigation.AppComposeNavigator
import com.shushant.navigation.ChattiezScreens

fun NavGraphBuilder.chattiezSplash(
    composeNavigator: AppComposeNavigator,
) {
    composable(route = ChattiezScreens.Splash.name) {
        SplashScreen(composeNavigator = composeNavigator)
    }
}

fun NavGraphBuilder.chattiezOnBoarding(
    composeNavigator: AppComposeNavigator
) {
    composable(route = ChattiezScreens.OnBoarding.name) {
        OnBoarding(
            composeNavigator = composeNavigator
        )
    }
}

fun NavGraphBuilder.chattiezAuthFlow(composeNavigator: AppComposeNavigator) {
    composable(route = ChattiezScreens.AuthFlow.name) {
        AuthScreen(composeNavigator = composeNavigator)
    }

    composable(route = ChattiezScreens.Login.route) {
        LoginScreen(composeNavigator = composeNavigator)
    }
}