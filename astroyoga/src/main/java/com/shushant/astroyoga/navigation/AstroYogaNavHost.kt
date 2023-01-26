package com.shushant.astroyoga.navigation

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.shushant.astroyoga.ui.MainViewModel
import com.shushant.navigation.AstroYogaScreens

@Composable
fun AstroYogaNavHost(
    navHostController: NavHostController,
    mainViewModel: MainViewModel,
    modifier: Modifier,
) {
    val composeNavigator = mainViewModel.navigator
    val authState by mainViewModel.getAuthState().collectAsState()
    val splashUiState by mainViewModel.state.collectAsStateWithLifecycle()
    NavHost(
        navController = navHostController,
        startDestination = AstroYogaScreens.Splash.route,
        modifier = modifier.navigationBarsPadding()
    ) {
        astroSplash(
            composeNavigator = composeNavigator,
            authState = authState,
            splashUiState = splashUiState
        )
        astroOnBoarding(
            composeNavigator = composeNavigator
        )
        astroAuthFlow(
            composeNavigator = composeNavigator,
        )
    }
}
