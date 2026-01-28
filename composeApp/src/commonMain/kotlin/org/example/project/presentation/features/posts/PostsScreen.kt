package org.example.project.presentation.features.posts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import io.ktor.websocket.Frame
import org.koin.compose.koinInject


import org.koin.compose.viewmodel.koinViewModel // ใช้ Koin สำหรับ Compose

class TestScreen : Screen {

    @Composable
    override fun Content() {

        val viewModel: PostViewModel = koinInject()

        val state by viewModel.uiState.collectAsState(
            initial = PostUiState.Loading
        )
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            when (val uiState = state) {
                is PostUiState.Loading ->
                    BasicText("Loading...")

                is PostUiState.Error ->
                    BasicText("Error: ${uiState.message}")

                is PostUiState.Success ->
                    LazyColumn {
                        items(uiState.posts) { post ->
                            BasicText("${post.id}: ${post.title}")
                        }
                    }
            }
        }
    }

}