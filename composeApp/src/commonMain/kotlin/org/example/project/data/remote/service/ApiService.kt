package org.example.project.data.remote.service

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.delay
import org.example.project.data.remote.dto.PostDto

class ApiService(private val client: HttpClient) {

    // ✅ เรียกแค่ "posts" พอ (Ktor จะเอาไปต่อกับ Base URL ให้เอง)
    suspend fun getPosts(): List<PostDto> {
        return client.get("posts").body()
    }

    // ตัวอย่าง: ถ้ามี path อื่นๆ ก็เพิ่มง่ายเลย
    // suspend fun getPostById(id: Int): PostDto {
    //     return client.get("posts/$id").body()
    // }
}