package org.example.project.ui


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import org.example.project.presentation.component.TabItem
import org.example.project.presentation.tabs.AssetTab
import org.example.project.presentation.tabs.DebtTab
import org.example.project.presentation.tabs.HomeTab
import org.example.project.presentation.tabs.ProfileTab
import org.example.project.presentation.tabs.SocialTab


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
                    TabItem(tab = AssetTab)
                    TabItem(tab = DebtTab)
                    TabItem(tab = SocialTab)
                    TabItem(tab = ProfileTab)
                }
            }
        ) { padding ->
            Box(Modifier.padding(padding)) {
                CurrentTab()
            }
        }
    }
}
