package org.example.project.presentation.tabs

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import wealthvault_mp_fe.composeapp.generated.resources.Res
import wealthvault_mp_fe.composeapp.generated.resources.social
import org.jetbrains.compose.resources.painterResource


object SocialTab : Tab {

    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 3u,
            title = "Social",
            icon = painterResource(Res.drawable.social)
        )

    @Composable
    override fun Content() {
        Text("Social Screen")
    }
}