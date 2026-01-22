package org.example.project.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object KtorClient {
    val client = HttpClient {
        // ส่วนนี้สำคัญมาก ห้ามลืม!
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true // ป้องกันแอปพังถ้า API ส่ง field แปลกๆ มา
                isLenient = true
            })
        }
    }
}