package org.example.project.presentation.tabs

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import wealthvault_mp_fe.composeapp.generated.resources.Res
import wealthvault_mp_fe.composeapp.generated.resources.main
import org.jetbrains.compose.resources.painterResource


object HomeTab : Tab {

    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 0u,
            title = "Main",
            icon = painterResource(Res.drawable.main)
        )

    @Composable
    override fun Content() {
        Text("Home Screen")
    }
}