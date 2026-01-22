package org.example.project.domain.usecase

import org.example.project.domain.model.Post
import org.example.project.domain.repository.PostRepository

class GetPostsUseCase(private val repository: PostRepository) {
    // เรียกใช้ผ่าน operator invoke เพื่อให้เรียกใช้ได้เหมือนฟังก์ชัน
    suspend operator fun invoke(): Result<List<Post>> {
        return try {
            val posts = repository.getPosts()
            Result.success(posts)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}