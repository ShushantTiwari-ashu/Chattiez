package com.shushant.chattiez.data.utils

import kotlinx.serialization.json.Json

val DEFAULT_JSON_FORMAT = Json {
    ignoreUnknownKeys = true
}