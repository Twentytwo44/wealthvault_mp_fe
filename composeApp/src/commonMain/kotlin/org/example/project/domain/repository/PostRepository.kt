package org.example.project.domain.repository

import org.example.project.domain.model.Post

interface PostRepository {
    suspend fun getPosts(): List<Post>
}