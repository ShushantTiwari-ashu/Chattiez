@file:Suppress("DEPRECATION")

package com.shushant.common.compose.utils

import android.content.Context
import android.os.Build
import java.util.Locale

val Context.primaryLocale: Locale
    get() =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            resources.configuration.locales[0]
        } else {
            resources.configuration.locale
        }
