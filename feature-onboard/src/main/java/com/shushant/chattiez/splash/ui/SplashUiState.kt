package com.shushant.chattiez.splash.ui

import com.shushant.chattiez.data.base.State
import com.shushant.resource.AppResource

data class SplashUiState(
    val background: AppResource = AppResource.UNKNOWN,
    val logo: AppResource = AppResource.UNKNOWN
) : State