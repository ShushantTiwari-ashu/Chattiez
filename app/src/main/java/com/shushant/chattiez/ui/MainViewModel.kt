package com.shushant.chattiez.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shushant.chattiez.data.datastore.PrefStorage
import com.shushant.navigation.AppComposeNavigator
import kotlinx.coroutines.DisposableHandle
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModel(
    appComposeNavigator: AppComposeNavigator, private val preferences: PrefStorage
) : ViewModel(), DisposableHandle {

    val navigator: AppComposeNavigator = appComposeNavigator
    private val job = Job()

    fun setTheme(isDark: Boolean) {
        viewModelScope.launch(job) {
            preferences.setCurrentTheme(isDark)
        }
    }

    fun isDarkTheme() = preferences.getThemeState

    override fun dispose() {
        job.cancel()
    }
}