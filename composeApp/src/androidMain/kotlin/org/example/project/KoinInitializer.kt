package org.example.project

import org.example.project.di.appModule
import org.example.project.di.networkModule
import org.koin.core.context.startKoin

actual object KoinInitializer {
    actual fun init() {
        println(">>> Koin started (iOS)")
        startKoin {
            modules(networkModule,appModule)
        }
    }
}