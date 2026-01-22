package org.example.project

import org.example.project.di.appModule
import org.koin.core.context.startKoin

actual object KoinInitializer {
    actual fun init() {
        println(">>> Koin started (iOS)")
        startKoin {
            modules(appModule)
        }
    }
}