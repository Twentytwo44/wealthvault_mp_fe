package org.example.project.di

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val androidModule = module {
    // Android ต้องส่ง Context ให้ KVault
    single { com.liftric.kvault.KVault(androidContext(), "MyAppSecureStorage") }
}