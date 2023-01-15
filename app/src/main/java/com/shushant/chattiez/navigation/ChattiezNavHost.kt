package com.shushant.chattiez.navigation

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.shushant.chattiez.ui.MainViewModel
import com.shushant.navigation.ChattiezScreens

@Composable
fun ChattiezNavHost(
    navHostController: NavHostController, mainViewModel: MainViewModel
) {
    val composeNavigator = mainViewModel.navigator
    NavHost(
        navController = navHostController,
        startDestination = ChattiezScreens.Splash.route,
        modifier = Modifier.navigationBarsPadding()
    ) {
        chattiezSplash(
            composeNavigator = composeNavigator
        )
        chattiezOnBoarding(
            composeNavigator = composeNavigator,
            theme = mainViewModel.isDarkTheme()
        )
        chattiezAuthFlow(
            composeNavigator = composeNavigator
        )
    }
}
