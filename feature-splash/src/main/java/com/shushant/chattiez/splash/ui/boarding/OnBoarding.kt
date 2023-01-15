package com.shushant.chattiez.splash.ui.boarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.shushant.navigation.AppComposeNavigator
import com.shushant.resource.ChatIcons

@Composable
fun OnBoarding(composeNavigator: AppComposeNavigator) {

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = ChatIcons.BG_SVG.drawable),
            contentDescription = "",
            modifier = Modifier.fillMaxSize()
        )

        Image(
            painter = painterResource(id = ChatIcons.LOGO.drawable),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.Center)
                .size(200.dp)
        )
    }
}