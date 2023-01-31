package com.shushant.astroyoga.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.shushant.astroyoga.data.datastore.PrefStorage
import com.shushant.astroyoga.compatibility.graph.CompatibilityScreen
import com.shushant.astroyoga.compatibility.graph.HoroscopeScreen
import com.shushant.astroyoga.compatibility.graph.ProfileScreen
import com.shushant.navigation.destinations.BottomNavItem
import com.shushant.astroyoga.onboard.navigation.OnBoarding
import com.shushant.astroyoga.onboard.navigation.astroOnBoarding
import com.shushant.astroyoga.onboard.navigation.astroSplash
import com.shushant.navigation.AppComposeNavigator
import com.shushant.navigation.Graph


fun NavGraphBuilder.onBoardingGraph(
    composeNavigator: AppComposeNavigator,
) {
    navigation(
        route = Graph.ONBOARDING,
        startDestination = OnBoarding.OnBoard.name
    ) {
        astroOnBoarding(composeNavigator)
    }
}

fun NavGraphBuilder.splashGraph(
    composeNavigator: AppComposeNavigator,
    preferences: PrefStorage,
) {
    navigation(
        route = Graph.SPLASH,
        startDestination = OnBoarding.Splash.name
    ) {
        astroSplash(
            composeNavigator = composeNavigator,
            preferences = preferences,
        )
    }
}


fun NavGraphBuilder.homeGraph(
    composeNavigator: AppComposeNavigator,
) {
    navigation(
        route = Graph.HOME,
        startDestination = BottomNavItem.Horoscope.screen_route
    ) {
        composable(BottomNavItem.Horoscope.screen_route) {
            HoroscopeScreen(composeNavigator)
        }
        composable(BottomNavItem.Compatibility.screen_route) {
            CompatibilityScreen(composeNavigator)
        }
        composable(BottomNavItem.Profile.screen_route) {
            ProfileScreen(composeNavigator)
        }
    }
}


