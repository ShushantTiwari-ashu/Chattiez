package com.shushant.chattiez.splash.filldetails

import androidx.compose.runtime.Composable
import com.shushant.chattiez.data.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class UserDetailsViewModel : BaseViewModel<UserDetailsState>(UserDetailsState()) {

    val composableScreens = MutableStateFlow(emptyList<UserScreens>())

    val selectedIndex = MutableStateFlow(0)


    fun setSelectedIndex(page: Int) {
        selectedIndex.update { page }
    }

    fun addComposables(action: List<@Composable (() -> Unit)>) {
        composableScreens.update {
            mutableListOf<UserScreens>().apply {
                action.map {
                    add(UserScreens(action = it))
                }
            }
        }
    }

    fun setUserName(userName: String) {
        setState { state -> state.copy(userName = userName) }
    }

    fun setGender(gender: Gender) {
        setState { state -> state.copy(gender = gender) }
    }

    fun setSentimentalStatus(sentimentalStatus: SentimentalStatus) {
        setState { state -> state.copy(sentimentalStatus = sentimentalStatus) }
    }

    fun setDob(dob: String) {
        setState { state -> state.copy(dob = dob) }
    }

    fun setTob(tob: String) {
        setState { state -> state.copy(tob = tob) }
    }

    fun setPob(pob: String) {
        setState { state -> state.copy(pob = pob) }
    }


}