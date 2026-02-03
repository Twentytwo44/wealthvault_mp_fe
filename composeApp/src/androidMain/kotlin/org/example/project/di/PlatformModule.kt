package org.example.project.di

import org.example.project.storage.createDataStore
import org.koin.dsl.module

actual val platformModule = module {
    // ฝั่ง Android สร้าง DataStore โดยส่ง Context (get()) เข้าไป
    single { createDataStore(context = get()) }
}