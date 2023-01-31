@file:Suppress("DEPRECATION")

package com.shushant.common.compose.utils

import android.content.Context
import android.os.Build
import java.util.Locale

val Context.primaryLocale: Locale
    get() =
        resources.configuration.locales[0]


internal fun Float.roundTo(n: Int): Float {
    return try {
        "%.${n}f".format(Locale.US, this).toFloat()
    } catch (e: NumberFormatException) {
        this
    }
}

val Int.minutes get() = (this / 60).toString().padStart(2, '0')

val Int.seconds get() = (this % 60).toString().padStart(2, '0')