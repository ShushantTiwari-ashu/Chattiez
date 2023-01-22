package com.shushant.chattiez.data.base

import androidx.compose.material3.SnackbarDuration

data class SnackBarState(
    val show: Boolean = false,
    val message: String = "",
    val duration: SnackbarDuration = SnackbarDuration.Long
)