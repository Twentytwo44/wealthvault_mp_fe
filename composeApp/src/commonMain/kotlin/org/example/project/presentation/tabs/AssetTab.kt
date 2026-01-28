package org.example.project.presentation.tabs

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import wealthvault_mp_fe.composeapp.generated.resources.Res
import wealthvault_mp_fe.composeapp.generated.resources.asset
import org.jetbrains.compose.resources.painterResource

object AssetTab : Tab {

    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 1u,
            title = "Asset",
            icon = painterResource(Res.drawable.asset)
        )

    @Composable
    override fun Content() {
        Text("Asset Screen")
    }
}
