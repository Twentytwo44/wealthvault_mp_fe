package org.example.project

import androidx.compose.ui.window.ComposeUIViewController
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.background
import androidx.compose.foundation.text.BasicText
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.*



fun MainViewController() = ComposeUIViewController {
    remember {
        KoinInitializer.init()
        true
    }
    AppIOS()
}