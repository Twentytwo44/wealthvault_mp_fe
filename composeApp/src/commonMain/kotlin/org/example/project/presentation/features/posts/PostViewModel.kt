package org.example.project.presentation.features.posts

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.example.project.domain.usecase.GetPostsUseCase

class PostViewModel(
    private val getPostsUseCase: GetPostsUseCase
) {

    private val scope = CoroutineScope(
        SupervisorJob() + Dispatchers.Main
    )

    private val _uiState = MutableStateFlow<PostUiState>(PostUiState.Loading)
    val uiState: StateFlow<PostUiState> = _uiState

    init {
        fetchPosts()
    }

    private fun fetchPosts() {
        scope.launch {
            _uiState.value = PostUiState.Loading

            getPostsUseCase()
                .onSuccess { posts ->
                    _uiState.value = PostUiState.Success(posts)
                }
                .onFailure { error ->
                    _uiState.value =
                        PostUiState.Error(error.message ?: "Unknown error")
                }
        }
    }

    fun clear() {
        scope.cancel()
    }
}
