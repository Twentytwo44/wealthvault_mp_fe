package org.example.project

import androidx.compose.material3.MaterialTheme

import androidx.compose.runtime.*

import org.example.project.ui.MainScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext

@Composable
fun App() {
    MaterialTheme {
        KoinContext {
            MainScreen()
        }
    }
}