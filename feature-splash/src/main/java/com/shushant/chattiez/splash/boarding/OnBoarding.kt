package com.shushant.chattiez.splash.boarding

import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import com.shushant.chatiez.feature.splash.R
import com.shushant.navigation.AppComposeNavigator
import com.shushant.navigation.ChattiezScreens
import com.shushant.resource.ChatIcons
import com.shushant.resource.getIllustration
import kotlinx.coroutines.delay

@Composable
fun OnBoarding(composeNavigator: AppComposeNavigator, theme: State<Boolean>) {
    val moveScreen = remember {
        mutableStateOf(1)
    }
    LaunchedEffect(Unit) {
        repeat(2) {
            delay(1500L)
            moveScreen.value = moveScreen.value + 1
        }
    }

    when (moveScreen.value) {
        1 -> {
            OnBoardingScreen(
                bgImage = ChatIcons.BG_ON_BOARDING1,
                illustration = ChatIcons.ILLUSTRATION,
                title = stringResource(R.string.onboarding_title),
                subtitle = stringResource(R.string.onboarding_subtitle),
                value = moveScreen.value
            ) {
                composeNavigator.navigateAndClearBackStack(ChattiezScreens.AuthFlow.route)
            }
        }
        2 -> {
            OnBoardingScreen(
                bgImage = ChatIcons.BG_ON_BOARDING1,
                illustration = theme.value.getIllustration,
                title = stringResource(R.string.stay_connected),
                subtitle = stringResource(R.string.subtitle2),
                value = moveScreen.value
            ) {
                composeNavigator.navigateAndClearBackStack(ChattiezScreens.AuthFlow.route)
            }
        }
        else -> {
            composeNavigator.navigateAndClearBackStack(ChattiezScreens.AuthFlow.route)
        }
    }
}
