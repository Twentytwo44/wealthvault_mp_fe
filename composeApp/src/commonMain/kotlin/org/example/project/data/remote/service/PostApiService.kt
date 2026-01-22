package org.example.project.data.remote.service

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.example.project.data.remote.dto.PostDto

class PostService(private val client: HttpClient) {

    // ประกาศ Endpoint ทั้งหมดที่นี่
    suspend fun fetchPosts(): List<PostDto> {
        return client.get("https://jsonplaceholder.typicode.com/posts").body<List<PostDto>>()    }

    suspend fun fetchPostById(id: Int): PostDto {
        return client.get("https://jsonplaceholder.typicode.com/posts/$id").body()
    }
}