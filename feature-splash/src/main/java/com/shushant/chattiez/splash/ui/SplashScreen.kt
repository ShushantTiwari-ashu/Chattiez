package com.shushant.chattiez.splash.ui

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.shushant.navigation.AppComposeNavigator
import com.shushant.navigation.ChattiezScreens
import com.shushant.resource.ChatIcons
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(composeNavigator: AppComposeNavigator) {
    val scale = remember {
        Animatable(0f)
    }

    // Animation
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            // tween Animation
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )

        // Customize the delay time
        delay(2000L)
        composeNavigator.navigate(ChattiezScreens.OnBoarding.route)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = ChatIcons.BG.drawable),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Image(
            painter = painterResource(id = ChatIcons.LOGO.drawable),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.Center)
                .scale(scale.value)
                .size(200.dp)
        )
    }
}