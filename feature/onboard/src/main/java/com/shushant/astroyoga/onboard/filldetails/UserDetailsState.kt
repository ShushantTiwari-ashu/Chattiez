package com.shushant.astroyoga.onboard.filldetails

import androidx.compose.runtime.Composable
import com.shushant.astroyoga.data.base.State
import com.shushant.astroyoga.data.model.LocationSearchResultItem
import com.shushant.astroyoga.data.model.User
import com.shushant.astroyoga.network.utils.json
import com.skydoves.whatif.whatIfNotNullOrEmpty
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import java.time.LocalDate
import java.time.Month

@Serializable
data class UserDetailsState(
    val deviceId: String = "",
    val userName: String = "",
    val success: Boolean = false,
    val loading: Boolean = false,
    val error: String = "",
    val gender: Gender = Gender.UNKNOWN,
    val sentimentalStatus: SentimentalStatus = SentimentalStatus.UNKNOWN,
    val dob: String = "",
    val tob: String = "",
    val pob: LocationSearchResultItem? = null,
    val handReadingData: String? = null,
    val filledIndex: Int = 0,
    val zodiacSign: String = ""
) : State


fun User.mapToUserState() = UserDetailsState(
    deviceId = deviceId ?: "",
    zodiacSign = dob.getZodiacSign() ?: "",
    userName = username,
    pob = pob?.let { json.decodeFromString(it) },
    sentimentalStatus = SentimentalStatus.valueOf(sentimentalStatus),
    tob = tob,
    handReadingData = handReadingData,
    gender = Gender.valueOf(gender),
    dob = dob,
    filledIndex = filledIndex ?: 0
)


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

val sentimentalStatus = mutableListOf(
    SentimentalStatus.SINGLE,
    SentimentalStatus.IN_RELATIONSHIP,
    SentimentalStatus.MARRIED,
    SentimentalStatus.DIVORCED,
    SentimentalStatus.WIDOWED,
)

fun String.getZodiacSign(): String {
    val dob = LocalDate.parse(this)
    val day = dob.dayOfMonth
    when (dob.month) {
        Month.JANUARY -> return if (day < 20)
            "Capricorn"
        else
            "Aquarius"
        Month.FEBRUARY -> return if (day < 19)
            "Aquarius"
        else
            "Pisces"
        Month.MARCH -> return if (day < 21)
            "Pisces"
        else
            "Aries"
        Month.APRIL -> return if (day < 20)
            "Aries"
        else
            "Taurus"
        Month.MAY -> return if (day < 21)
            "Taurus"
        else
            "Gemini"
        Month.JUNE -> return if (day < 21)
            "Gemini"
        else
            "Cancer"
        Month.JULY -> return if (day < 23)
            "Cancer"
        else
            "Leo"
        Month.AUGUST -> return if (day < 23)
            "Leo"
        else
            "Virgo"
        Month.SEPTEMBER -> return if (day < 23)
            "Virgo"
        else
            "Libra"
        Month.OCTOBER -> return if (day < 23)
            "Libra"
        else
            "Scorpio"
        Month.NOVEMBER -> return if (day < 22)
            "Scorpio"
        else
            "Sagittarius"
        Month.DECEMBER -> return if (day < 22)
            "Sagittarius"
        else
            "Capricorn"
        else -> return ""
    }
}
