package org.example.project.data.repository

import io.ktor.client.call.body
import io.ktor.client.request.get
import org.example.project.data.remote.KtorClient
import org.example.project.data.remote.dto.PostDto
import org.example.project.domain.model.Post
import org.example.project.domain.repository.PostRepository

class PostRepositoryImpl : PostRepository {
    private val client = KtorClient.client

    override suspend fun getPosts(): List<Post> {
        // 1. Fetch data from API
        val response: List<PostDto> = client.get("https://jsonplaceholder.typicode.com/posts").body()

        // 2. Map DTO -> Domain Model (Clean Architecture Rule)
        return response.map { dto ->
            Post(
                id = dto.id,
                title = dto.title,
                body = dto.body
            )
        }
    }
}