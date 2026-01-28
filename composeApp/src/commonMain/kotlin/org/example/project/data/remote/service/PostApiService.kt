package org.example.project.data.remote.service

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.example.project.data.remote.dto.PostDto

class PostService(private val client: HttpClient) {

    suspend fun fetchPosts(): List<PostDto> {
        // ✅ ตัด Domain ออก ใส่แค่ path ข้างหลัง
        // Ktor จะเอาไปต่อกับ Global Link ให้เองอัตโนมัติครับ
        return client.get("posts").body()
    }

    suspend fun fetchPostById(id: Int): PostDto {
        // ✅ สั้นและสะอาด
        return client.get("posts/$id").body()
    }
}