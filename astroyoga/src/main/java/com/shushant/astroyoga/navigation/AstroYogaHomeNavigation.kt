package com.shushant.astroyoga.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.shushant.chattiez.auth.AuthScreen
import com.shushant.chattiez.auth.activated.AccountActivated
import com.shushant.chattiez.auth.login.LoginScreen
import com.shushant.chattiez.auth.signup.SignUpScreen
import com.shushant.chattiez.splash.filldetails.GetDetailsCarousel
import com.shushant.chattiez.splash.ui.SplashScreen
import com.shushant.chattiez.splash.onboarding.AstroOnBoarding
import com.shushant.chattiez.splash.ui.SplashUiState
import com.shushant.navigation.AppComposeNavigator
import com.shushant.navigation.AstroYogaScreens
import com.shushant.navigation.ChattiezScreens

fun NavGraphBuilder.astroSplash(
    composeNavigator: AppComposeNavigator,
    authState: Boolean,
    splashUiState: SplashUiState,
) {
    composable(route = AstroYogaScreens.Splash.name) {
        SplashScreen(
            composeNavigator = composeNavigator,
            isUserSignedOut = authState,
            splashUiState = splashUiState
        )
    }
}

fun NavGraphBuilder.astroOnBoarding(
    composeNavigator: AppComposeNavigator
) {
    composable(route = AstroYogaScreens.OnBoarding.name) {
        AstroOnBoarding(
            composeNavigator = composeNavigator
        )
    }
    composable(route = AstroYogaScreens.TakeUserDetails.name) {
        GetDetailsCarousel(
            composeNavigator = composeNavigator
        )
    }
}

fun NavGraphBuilder.astroAuthFlow(
    composeNavigator: AppComposeNavigator,
) {
    composable(route = ChattiezScreens.AuthFlow.name) {
        AuthScreen(composeNavigator = composeNavigator)
    }

}