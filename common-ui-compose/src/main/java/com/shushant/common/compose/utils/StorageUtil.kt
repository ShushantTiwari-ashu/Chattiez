package com.shushant.common.compose.utils

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.os.storage.StorageManager
import android.provider.MediaStore
import androidx.annotation.RequiresApi
import java.io.File
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

class StorageUtil {
    companion object {
        /**
         * use API SDK < Q
         */
        @SuppressLint("SimpleDateFormat")
        fun createFile(type: String, suffix: String): File {
            // Create an file name
            val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
            val fileName = type + timeStamp
            val storageDir = Environment.getExternalStoragePublicDirectory(
                type
            )
            return File.createTempFile(
                fileName, /* prefix */
                suffix, /* suffix */
                storageDir /* directory */
            )
        }

        @RequiresApi(Build.VERSION_CODES.Q)
        @SuppressLint("SimpleDateFormat")
        fun createFile(context: Context, type: String, suffix: String): Uri? {
            val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
            val fileName = type + timeStamp
            val tableUri: Uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            val values: ContentValues = ContentValues()
                .apply {
                    put(MediaStore.Images.Media.DISPLAY_NAME, fileName)
                    put(MediaStore.Images.Media.MIME_TYPE, "image/$suffix")
                    put(MediaStore.Images.Media.RELATIVE_PATH, type)
                    put(MediaStore.Images.Media.DATE_ADDED, System.currentTimeMillis())
                }

            return context.contentResolver.insert(tableUri, values)
        }

        fun createImageFile(): File {
            return createFile(Environment.DIRECTORY_PICTURES, ".jpg")
        }

        @RequiresApi(Build.VERSION_CODES.Q)
        fun createImageFileUri(context: Context): Uri? {
            return createFile(context, Environment.DIRECTORY_PICTURES, "jpeg")
        }

        fun isFilePresent(path: String, fileName: String): Boolean {
            val filePath = "$path/$fileName"
            return File(filePath).exists()
        }

        fun getFilepathPresentInDownloadFolder(filename: String, context: Context): String? {

            val directoryPath = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                val storageManager: StorageManager =
                    context.getSystemService(Context.STORAGE_SERVICE) as StorageManager
                "${storageManager.primaryStorageVolume.directory?.absolutePath}/${Environment.DIRECTORY_DOWNLOADS}"
            } else {
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).absolutePath
            }

            var filePath: String? = null
            if (isFilePresent(directoryPath, filename))
                filePath = "$directoryPath/$filename"

            return filePath
        }

        fun getFilename(fileName: String?) =
            if (fileName.isNullOrEmpty()) {
                "${Calendar.getInstance().timeInMillis}.pdf"
            } else {
                fileName
            }
    }
}
