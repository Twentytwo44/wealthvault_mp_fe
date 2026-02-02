package org.example.project.domain.repository

import org.example.project.data.remote.dto.LoginResponse

interface AuthRepository {
    suspend fun login(username: String, pass: String): Result<LoginResponse>
}