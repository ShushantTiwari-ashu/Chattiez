package com.shushant.common.compose.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkChattiezColorScheme = darkColorScheme(
    primary = PURPLE700,
    primaryContainer = DARK_PURPLE300,
    secondary = PURPLE500,
    background = DARK_PURPLE300,
    tertiary = WHITE200,
    onTertiary = GRAY200
)

private val LightChattiezColorScheme = lightColorScheme(
    primary = PURPLE500,
    primaryContainer = PURPLE700,
    secondary = PURPLE300,
    background = WHITE200,
    tertiary = WHITE200,
    onTertiary = GRAY200
)

/** Light Android background theme */
private val LightAndroidBackgroundTheme = BackgroundTheme(color = LIGHT_COLOR)

/** Dark Android background theme */
private val DarkAndroidBackgroundTheme = BackgroundTheme(color = DARK_PURPLE300)

@Composable
fun ChattiezTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkChattiezColorScheme else LightChattiezColorScheme
    val backgroundTheme = if (darkTheme) DarkAndroidBackgroundTheme else LightAndroidBackgroundTheme
    val systemUiController = rememberSystemUiController()

    SideEffect {
        // Changing status bar icons as user pref
        systemUiController.setStatusBarColor(
            color = Color.Transparent,
            darkIcons = !darkTheme
        )

        // Changing navigation bar icons as user pref
        systemUiController.setNavigationBarColor(
            color = Color.Transparent,
            darkIcons = !darkTheme
        )
    }

    CompositionLocalProvider(
        LocalBackgroundTheme provides backgroundTheme
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}

val textColor: Color
    @Composable
    @ReadOnlyComposable
    get() = if (isSystemInDarkTheme())
        TextColorWhite
    else
        TextColorBlack

val circleProgressColor: Color
    @Composable
    @ReadOnlyComposable
    get() = if (isSystemInDarkTheme())
        PRIMARY500
    else
        CircleStrokeColor
val centerCircleColor: Color
    @Composable
    @ReadOnlyComposable
    get() = if (isSystemInDarkTheme())
        PRIMARY700
    else
        WHITE200

val buttonColor: Color
    @Composable
    @ReadOnlyComposable
    get() = if (isSystemInDarkTheme())
        BUTTON_COLOR_PURPLE
    else
        WHITE200