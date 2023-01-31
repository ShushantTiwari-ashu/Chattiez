package com.shushant.astroyoga.main.ui

import androidx.lifecycle.ViewModel
import com.shushant.navigation.AppComposeNavigator

class HomeViewModel(private val composeNavigator: AppComposeNavigator) : ViewModel() {

    val navigator = composeNavigator
}


