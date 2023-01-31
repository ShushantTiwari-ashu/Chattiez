package com.shushant.astroyoga.onboard.repo

import com.shushant.astroyoga.data.model.HoroscopeResponse
import com.shushant.astroyoga.data.repo.HoroScopeRequest
import com.shushant.astroyoga.data.repo.HoroscopeAnalyzeRepository
import com.shushant.astroyoga.network.utils.Either
import com.shushant.astroyoga.network.utils.HOROSCOPE
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HoroscopeAnalyzeRepositoryImpl(private val client: HttpClient) : HoroscopeAnalyzeRepository {
    override suspend fun getHoroscope(request: HoroScopeRequest): Either<HoroscopeResponse> =
        withContext(Dispatchers.IO) {
            try {
                val result = client.post {
                    url(HOROSCOPE)
                    url {
                        parameters.append("sign", request.sign)
                        parameters.append("day", request.day)
                    }
                }.body<HoroscopeResponse>()
                Either.success(result)
            } catch (e: Exception) {
                Either.error(e.message ?: "")
            }
        }
}