package org.example.project.di


import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.example.project.data.remote.service.AuthService
import org.koin.dsl.module
import org.example.project.data.remote.service.PostService

val networkModule = module {

    // 1. สร้าง HttpClient (ไม่ต้องระบุ Engine ตรงนี้)
    single {
        HttpClient {
            // ✅ 1.1 ตั้งค่า JSON
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                    isLenient = true
                })
            }

            // ✅ 1.2 ตั้ง Base URL
            defaultRequest {
//                url("https://jsonplaceholder.typicode.com/")
                url("http://10.0.2.2:8080/api/")
            }

            // ✅ 1.3 (แนะนำ) ใส่ Log เพื่อดูว่ายิง API อะไรออกไปบ้าง
            install(Logging) {
                logger = Logger.SIMPLE
                level = LogLevel.ALL // ดูทั้ง Headers และ Body
            }
        }
    }

    // 2. สร้าง Service
    factory { PostService(get()) }

    factory { AuthService(get()) }
}