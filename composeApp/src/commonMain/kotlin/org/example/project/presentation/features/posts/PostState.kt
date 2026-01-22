package org.example.project.presentation.features.posts

import org.example.project.domain.model.Post

sealed interface PostUiState {
    data object Loading : PostUiState
    data class Success(val posts: List<Post>) : PostUiState
    data class Error(val message: String) : PostUiState
}