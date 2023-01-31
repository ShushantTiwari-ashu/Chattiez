package com.shushant.astroyoga.network.utils

import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Singleton
val json = Json { encodeDefaults = true }

const val HOROSCOPE = "https://aztro.sameerkumar.website/"
const val LOCATIONS = "https://nominatim.openstreetmap.org/"