package com.shushant.chattiez.ui

import androidx.compose.material3.SnackbarDuration
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shushant.chattiez.R
import com.shushant.chattiez.data.base.SnackBarState
import com.shushant.chattiez.data.datastore.PrefStorage
import com.shushant.chattiez.data.utils.NetworkMonitor
import com.shushant.chattiez.network.client.AccountService
import com.shushant.navigation.AppComposeNavigator
import com.shushant.resource.ResourceProvider
import kotlinx.coroutines.DisposableHandle
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModel(
    appComposeNavigator: AppComposeNavigator,
    private val preferences: PrefStorage,
    private val accountService: AccountService,
    networkMonitor: NetworkMonitor,
    private val resourceProvider: ResourceProvider
) : ViewModel(), DisposableHandle {

    val navigator: AppComposeNavigator = appComposeNavigator

    val isOffline = networkMonitor.isOnline
        .map { boolean ->
            boolean.not()
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(1_000),
            initialValue = false
        )

    private val job = Job()

    init {
        getAuthState()
    }


    fun setTheme(isDark: Boolean) {
        viewModelScope.launch(job) {
            preferences.setCurrentTheme(isDark)
        }
    }


    fun isDarkTheme() = preferences.getThemeState

    fun getAuthState() = accountService.getAuthState(viewModelScope)

    val isEmailVerified get() = accountService.currentUser?.isEmailVerified ?: false

    override fun dispose() {
        job.cancel()
    }
}