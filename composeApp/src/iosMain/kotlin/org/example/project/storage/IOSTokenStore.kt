package org.example.project.storage

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import kotlinx.cinterop.ExperimentalForeignApi
import org.example.project.data.local.DATA_STORE_FILE_NAME
import org.example.project.data.local.createDataStoreFromFilePath

import platform.Foundation.*

@OptIn(ExperimentalForeignApi::class)
fun createDataStore(): DataStore<Preferences> {
    // ✅ เรียกชื่อใหม่ ใส่ Lambda ได้แล้ว ไม่ชนกันแน่นอน
    return createDataStoreFromFilePath {
        val documentDirectory: NSURL? = NSFileManager.defaultManager.URLForDirectory(
            directory = NSDocumentDirectory,
            inDomain = NSUserDomainMask,
            appropriateForURL = null,
            create = true,
            error = null,
        )

        val path = requireNotNull(documentDirectory).path
            ?: throw IllegalStateException("Document directory path is null")

        "$path/$DATA_STORE_FILE_NAME"
    }
}