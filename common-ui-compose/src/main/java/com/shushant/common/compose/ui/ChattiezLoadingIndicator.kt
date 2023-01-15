package com.shushant.common.compose.ui

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun BoxScope.ChattiezLoadingIndicator(color: Color) {
    CircularProgressIndicator(
        modifier = Modifier.align(Alignment.Center),
        color = color
    )
}