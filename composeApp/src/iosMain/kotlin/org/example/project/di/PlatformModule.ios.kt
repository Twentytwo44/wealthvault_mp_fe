package org.example.project.di

import org.example.project.data.local.createDataStoreFromFilePath
import org.example.project.storage.createDataStore
import org.koin.dsl.module

actual val platformModule = module {
    // เรียกใช้ฟังก์ชัน createDataStore ของฝั่ง iOS ได้เลย
    single { createDataStore() }
}