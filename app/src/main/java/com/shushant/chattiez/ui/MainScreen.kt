package com.shushant.chattiez.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.shushant.chattiez.navigation.ChattiezNavHost
import com.shushant.common.compose.ui.ChattiezBackground

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainScreen(mainViewModel: MainViewModel) {
    val navHostController = rememberAnimatedNavController()
    LaunchedEffect(Unit) {
        mainViewModel.navigator.handleNavigationCommands(navHostController)
    }
    ChattiezBackground {
        ChattiezNavHost(navHostController = navHostController, mainViewModel = mainViewModel)
    }
}



