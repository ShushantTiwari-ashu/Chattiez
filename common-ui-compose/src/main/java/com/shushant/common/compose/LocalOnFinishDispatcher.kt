package com.shushant.common.compose

import androidx.compose.runtime.compositionLocalOf

val LocalOnFinishDispatcher = compositionLocalOf<(() -> Unit)?> { null }