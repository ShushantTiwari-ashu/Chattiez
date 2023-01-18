package com.shushant.common.compose.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.shushant.chattiez.common.compose.R
import com.shushant.common.compose.theme.textColor

@Composable
fun ChattiezSpinner(
    modifier: Modifier = Modifier,
    color: Color = textColor.copy(0.7f)
) {
    // Make it clickable to that it stops things under from being clickable
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.trustmark_spinner))
    val progress by animateLottieCompositionAsState(composition)

    Surface(modifier = Modifier.fillMaxSize(), color = color) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null,
                    onClick = {}
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            LottieAnimation(
                composition = composition,
                progress = { progress },
            )
        }
    }
}