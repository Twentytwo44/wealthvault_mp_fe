package org.example.project.storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import org.example.project.data.local.DATA_STORE_FILE_NAME
import org.example.project.data.local.createDataStoreFromFilePath
import java.io.File

private val Context.dataStore by preferencesDataStore("app_datastore")

fun createDataStore(context: Context): DataStore<Preferences> {
    // ✅ แก้เป็นเรียก createDataStoreFromFilePath
    return createDataStoreFromFilePath {
        File(context.filesDir, "datastore/$DATA_STORE_FILE_NAME").absolutePath
    }
}