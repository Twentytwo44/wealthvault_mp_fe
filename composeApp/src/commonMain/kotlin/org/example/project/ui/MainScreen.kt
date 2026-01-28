package org.example.project.ui


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Box

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.TabNavigator
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.Tab
import org.example.project.presentation.component.TabItem
import org.example.project.presentation.tabs.HomeTab


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    TabNavigator(HomeTab) {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = { Text("Wealth & Vault") }
                )
            },
            bottomBar = {
                NavigationBar {
                    TabItem(tab = HomeTab)

                }
            }
        ) { padding ->
            Box(Modifier.padding(padding)) {
                CurrentTab()
            }
        }
    }
}
