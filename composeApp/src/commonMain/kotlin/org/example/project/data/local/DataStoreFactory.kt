package org.example.project.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import okio.Path.Companion.toPath

// ชื่อไฟล์ที่เก็บข้อมูล
internal const val DATA_STORE_FILE_NAME = "app_prefs.preferences_pb"

// ฟังก์ชันกลางที่รับ path มาสร้าง DataStore
fun createDataStoreFromFilePath(producePath: () -> String): DataStore<Preferences> {
    return PreferenceDataStoreFactory.createWithPath(
        produceFile = { producePath().toPath() }
    )
}