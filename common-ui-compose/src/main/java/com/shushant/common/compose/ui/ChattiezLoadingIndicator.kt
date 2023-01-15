package com.shushant.common.compose.ui

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.shushant.common.compose.theme.PURPLE450

@Composable
fun BoxScope.ChattiezLoadingIndicator() {
  CircularProgressIndicator(
    modifier = Modifier.align(Alignment.Center),
    color = PURPLE450
  )
}