package com.shushant.common.compose.utils

import android.content.Context
import timber.log.Timber
import java.io.BufferedWriter
import java.io.File
import java.io.FileNotFoundException
import java.io.FileReader
import java.io.FileWriter
import java.io.IOException

class FileCacheUtil(private val cacheDirectory: File, private val context: Context) {
    fun save(value: String, fileName: String) {
        try {
            val file = File(cacheDirectory, fileName)
            val fileWriter = FileWriter(file)
            val bufferedWriter = BufferedWriter(fileWriter)
            bufferedWriter.write(value)
            bufferedWriter.close()
        } catch (e: IllegalArgumentException) {
            Timber.e("Saving file $fileName failed" + e)
        } catch (e: SecurityException) {
            Timber.e("Saving file $fileName failed" + e)
        } catch (e: IOException) {
            Timber.e("Saving file $fileName failed" + e)
        }
    }

    fun load(fileName: String, fromApp: Boolean = false): String? {
        val file = File(cacheDirectory, fileName)
        return try {
            val fileReader = FileReader(file)
            val text = fileReader.readText()
            fileReader.close()
            text
        } catch (e: FileNotFoundException) {
            Timber.d("file $fileName not found$e")
            if (fromApp) {
                loadFromApp(fileName)
            } else null
        }
    }

    fun loadFromApp(fileName: String): String? {
        return try {
            val inputStream = context.assets.open(fileName)
            val data = inputStream.bufferedReader().use { it.readText() }
            data
        } catch (e: IOException) {
            Timber.e("file $fileName not found in app$e")
            null
        }
    }
}