package org.example.project.presentation.tabs

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import wealthvault_mp_fe.composeapp.generated.resources.Res
import wealthvault_mp_fe.composeapp.generated.resources.profile
import org.jetbrains.compose.resources.painterResource


object ProfileTab : Tab {

    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 4u,
            title = "Profile",
            icon = painterResource(Res.drawable.profile)
        )

    @Composable
    override fun Content() {
        Text("Profile Screen")
    }
}