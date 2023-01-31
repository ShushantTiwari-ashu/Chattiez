package com.shushant.astroyoga.data.repo

import com.shushant.astroyoga.data.model.HoroscopeResponse
import com.shushant.astroyoga.network.utils.Either

interface HoroscopeAnalyzeRepository {
    suspend fun getHoroscope(request: HoroScopeRequest): Either<HoroscopeResponse>
}

data class HoroScopeRequest(
    val sign: String,
    val day: String = "today"
)