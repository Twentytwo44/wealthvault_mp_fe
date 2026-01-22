package org.example.project.data.remote.dto

import kotlinx.serialization.Serializable


@Serializable
data class PostDto(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)