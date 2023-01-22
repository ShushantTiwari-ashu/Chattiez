package com.shushant.chattiez.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.shushant.chattiez.R
import com.shushant.chattiez.navigation.ChattiezNavHost
import com.shushant.common.compose.theme.LocalSnackbarHostState
import com.shushant.common.compose.ui.ChattiezBackground
import com.shushant.common.compose.ui.ChattiezSnackBar
import kotlinx.coroutines.launch

@OptIn(
    ExperimentalAnimationApi::class, ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class
)
@Composable
fun MainScreen(mainViewModel: MainViewModel) {
    val navHostController = rememberAnimatedNavController()
    val snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }
    val snackBarState by mainViewModel.isOffline.collectAsStateWithLifecycle()

    val notConnected = stringResource(id = R.string.not_connected)

    LaunchedEffect(Unit) {
        mainViewModel.navigator.handleNavigationCommands(navHostController)
    }
    ChattiezBackground {
        LaunchedEffect(snackBarState) {
            if (snackBarState) {
                snackbarHostState.showSnackbar(
                    message = notConnected, duration = SnackbarDuration.Indefinite
                )
            }
        }
        CompositionLocalProvider(
            LocalSnackbarHostState provides snackbarHostState
        ) {
            Scaffold(snackbarHost = {
                ChattiezSnackBar(snackbarHostState = snackbarHostState)
            },
                contentWindowInsets = WindowInsets(0, 0, 0, 0),
                contentColor = Color.Transparent,
                containerColor = Color.Transparent,
                bottomBar = {}) { padding ->
                ChattiezNavHost(
                    navHostController = navHostController,
                    mainViewModel = mainViewModel,
                    modifier = Modifier
                        .windowInsetsPadding(
                            WindowInsets.safeDrawing.only(
                                WindowInsetsSides.Horizontal
                            )
                        )
                        .padding(padding)
                        .consumedWindowInsets(padding)
                )
            }
        }
    }
}



