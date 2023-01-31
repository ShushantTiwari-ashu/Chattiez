package com.shushant.astroyoga.main.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.shushant.navigation.*
import com.shushant.navigation.destinations.BottomNavItem

fun NavGraphBuilder.homeInternalGraph(
    composeNavigator: AppComposeNavigator
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

@Composable
fun HoroscopeScreen(composeNavigator: AppComposeNavigator) {

}

@Composable
fun CompatibilityScreen(composeNavigator: AppComposeNavigator) {
    //composeNavigator.navigateAndClearBackStack(Graph.ONBOARDING, Graph.HOME)
}

@Composable
fun ProfileScreen(composeNavigator: AppComposeNavigator) {

}





