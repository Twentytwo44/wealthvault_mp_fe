package org.example.project.data.remote.service

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import org.example.project.data.remote.dto.LoginRequest
import org.example.project.data.remote.dto.LoginResponse
import org.example.project.data.remote.dto.PostDto


class AuthService(private val client: HttpClient) {

    suspend fun login(request: LoginRequest): LoginResponse {
        // ยิง POST ไปที่ endpoint "/auth/login" (สมมติว่าใช้ dummyjson)
        return client.post("auth/login") {
            contentType(ContentType.Application.Json) // บอก Server ว่าส่ง JSON นะ
            setBody(request) // เอา data ใส่ Body
        }.body()
    }
}