package org.example.project.presentation.tabs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions


object DebtTab : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val iconPainter = rememberVectorPainter(image = Icons.Default.Home)
            return TabOptions(
                index = 0u,
                title = "Home",
                icon = iconPainter
            )
        }

    @Composable
    override fun Content() {
        Text("Debt Screen")
    }
}