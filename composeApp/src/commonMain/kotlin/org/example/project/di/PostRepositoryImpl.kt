package org.example.project.di


import org.example.project.data.remote.service.PostService
import org.example.project.domain.model.Post
import org.example.project.domain.repository.PostRepository

class PostRepositoryImpl(
    private val apiService: PostService // Inject Service เข้ามาแทน Client
) : PostRepository {

    override suspend fun getPosts(): List<Post> {
        // 1. เรียกข้อมูลจาก Service (ได้ DTO)
        val postDtos = apiService.fetchPosts()

        // 2. แปลง DTO -> Domain Model
        return postDtos.map { dto ->
            Post(
                id = dto.id,
                title = dto.title,
                body = dto.body
            )
        }
    }
}