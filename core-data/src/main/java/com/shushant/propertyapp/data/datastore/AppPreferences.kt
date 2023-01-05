/*
 * Copyright (c) 2023 Shushant Tiwari.
 *
 * Licensed under the GNU General Public License v3
 *
 * This is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 */

package com.shushant.propertyapp.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.*
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.KSerializer
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppPreferences @Inject constructor(@ApplicationContext private val context: Context) :
    PrefStorage {
    private val datastoreUtils: DatastoreUtils = DatastoreUtils(context)

    companion object {
        val THEME_STATE_KEY = stringPreferencesKey(name = "theme_state")
    }

    private suspend fun <T> setValue(
        key: Preferences.Key<T>,
        value: T
    ) {
        datastoreUtils.setValue(key, value)
    }

    private suspend fun <T> setValue(
        key: Preferences.Key<String>,
        value: T,
        serializer: KSerializer<T>
    ) =
        datastoreUtils.setValue(key, value, serializer)

    private fun <T> getValue(
        key: Preferences.Key<T>,
        defaultValue: T
    ): Flow<T> =
        datastoreUtils.getValue(key, defaultValue)


    fun <T> getValue(
        name: Preferences.Key<String>,
        serializer: KSerializer<T>,
        defaultValue: T
    ): Flow<T> =
        datastoreUtils.getValue(name, serializer, defaultValue)

}