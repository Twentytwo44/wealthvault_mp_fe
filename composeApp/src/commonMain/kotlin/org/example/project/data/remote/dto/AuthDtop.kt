package org.example.project.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    val email: String,
    val password: String
)


@Serializable
data class LoginResponse(
    val status: String? = null,
    val data: LoginData? = null,
    val error: String? = null
)

// ชั้นใน (Data)
@Serializable
data class LoginData(
    val success: Boolean,
    val access_token: String,
    val refresh_token: String,
    val user_id: String
)