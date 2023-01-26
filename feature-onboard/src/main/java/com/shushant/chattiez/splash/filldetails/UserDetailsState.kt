package com.shushant.chattiez.splash.filldetails

import androidx.compose.runtime.Composable
import com.shushant.chattiez.data.base.State

data class UserDetailsState(
    val userName: String = "",
    val gender: Gender = Gender.UNKNOWN,
    val sentimentalStatus: SentimentalStatus = SentimentalStatus.UNKNOWN,
    val dob: String = "",
    val tob: String = "",
    val pob: String = "",
    val handReadingData: Any? = null,
) : State

data class UserScreens(val action: @Composable (() -> Unit)? = null)

enum class SentimentalStatus {
    SINGLE,
    IN_RELATIONSHIP,
    MARRIED,
    DIVORCED,
    WIDOWED,
    UNKNOWN
}

enum class Gender {
    MALE,
    FEMALE,
    NON_BINARY,
    UNKNOWN
}

val sentimentalStatus = mutableListOf<SentimentalStatus>(
    SentimentalStatus.SINGLE,
    SentimentalStatus.IN_RELATIONSHIP,
    SentimentalStatus.MARRIED,
    SentimentalStatus.DIVORCED,
    SentimentalStatus.WIDOWED,
)
