package com.shushant.chattiez.splash.filldetails

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun getCarouselItems(
    viewModel: UserDetailsViewModel,
    action: () -> Unit
): List<@Composable () -> Unit> {
    val userState by viewModel.state.collectAsStateWithLifecycle()
    return mutableListOf<@Composable (() -> Unit)>().apply {
        add {
            UserNameItem(viewModel::setUserName, userState) {
                action.invoke()
            }
        }
        add {
            TellYourGenderItem(viewModel::setGender, userState) {
                action.invoke()
            }
        }
        add {
            TellYourSentimentalStatusItem(viewModel::setSentimentalStatus, userState) {
                action.invoke()
            }
        }
        add {
            SelectorDOBItem(viewModel::setDob, userState) {
                action.invoke()
            }
        }
        add {
            SelectorTOBItem(viewModel::setTob, userState) {
                action.invoke()
            }
        }
    }
}