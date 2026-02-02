package org.example.project

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import org.example.project.presentation.auth.login.LoginScreen
import org.example.project.ui.AppTheme
import org.example.project.ui.MainScreen

@Composable
fun AppIOS() {
    AppRoot {
        AppTheme {
            Navigator(screen = LoginScreen())


        }
    }
}