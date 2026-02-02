package org.example.project.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    val username: String,
    val password: String
)


@Serializable
data class LoginResponse(
    val id: Int,
    val username: String,
    val email: String,
    val token: String
)