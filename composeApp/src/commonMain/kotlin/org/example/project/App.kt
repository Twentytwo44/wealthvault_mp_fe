package org.example.project

import androidx.compose.material3.MaterialTheme

import androidx.compose.runtime.*
import cafe.adriel.voyager.navigator.Navigator
import org.example.project.presentation.auth.login.LoginScreen
import org.example.project.ui.AppTheme

import org.example.project.ui.MainScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext

@Preview
@Composable
fun App() {
    AppTheme {
        KoinContext {
            Navigator(screen = LoginScreen())
        }
    }
}