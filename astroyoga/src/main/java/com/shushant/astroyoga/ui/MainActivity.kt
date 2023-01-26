package com.shushant.astroyoga.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.CompositionLocalProvider
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.shushant.common.compose.theme.AstroYogaTheme
import com.shushant.common.compose.utils.LocalOnFinishDispatcher
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            mainViewModel.setTheme(isSystemInDarkTheme())
            CompositionLocalProvider(LocalOnFinishDispatcher provides { finish() }) {
                AstroYogaTheme { MainScreen(mainViewModel = mainViewModel) }
            }
        }
    }
}