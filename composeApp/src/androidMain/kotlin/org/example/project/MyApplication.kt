package org.example.project

import android.app.Application
import org.example.project.di.appModule
import org.example.project.di.networkModule
import org.example.project.di.platformModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // สั่ง Start Koin ตรงนี้ (ทำครั้งเดียวตลอดอายุแอป)
        startKoin {
            // Log Koin errors to Android Logcat
            androidLogger()

            // REQUIRED: Pass the Android Context to Koin
            androidContext(this@MyApplication)

            // Load your modules
            modules(networkModule, appModule, platformModule)
        }
    }
}