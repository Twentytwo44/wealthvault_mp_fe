package org.example.project.data.repository

import org.example.project.data.local.TokenStore
import org.example.project.data.remote.dto.LoginRequest
import org.example.project.data.remote.dto.LoginResponse
import org.example.project.data.remote.service.AuthService
import org.example.project.domain.repository.AuthRepository

class AuthRepositoryImpl(private val api: AuthService,private val tokenStore: TokenStore) : AuthRepository {

    override suspend fun login(username: String, pass: String): Result<LoginResponse> {
        return try {
            // ยัด logic การเตรียม request ไว้ที่นี่
            val request = LoginRequest(username, pass)
            val response = api.login(request)
            response.data?.access_token?.let { token ->
                tokenStore.saveToken(token)
                println("AuthRepo: Saved token automatically.")
            } ?: run {

                println("AuthRepo: No token found in response.")
            }



            // ส่งคืนแบบ Result (Success/Failure) เพื่อให้ ViewModel จัดการง่าย
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}