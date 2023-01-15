package com.shushant.chattiez.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.shushant.chattiez.navigation.ChattiezNavHost
import com.shushant.common.compose.ui.ChattiezBackground
import com.shushant.navigation.AppComposeNavigator

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainScreen(composeNavigator: AppComposeNavigator) {
    val navHostController = rememberAnimatedNavController()
    LaunchedEffect(Unit) {
        composeNavigator.handleNavigationCommands(navHostController)
    }
    ChattiezBackground {
        ChattiezNavHost(navHostController = navHostController, composeNavigator = composeNavigator)
    }
}



