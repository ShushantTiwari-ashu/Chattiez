package com.shushant.chattiez.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.shushant.common.compose.LocalOnFinishDispatcher
import com.shushant.common.compose.theme.ChattiezTheme
import com.shushant.navigation.AppComposeNavigator
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val appComposeNavigator: AppComposeNavigator by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Makes content draw under status bar and navigation bar
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            CompositionLocalProvider(
                LocalOnFinishDispatcher provides { finish() }
            ) {
                ChattiezTheme { MainScreen(composeNavigator = appComposeNavigator) }
            }
        }
    }
}