package org.example.project.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import org.example.project.presentation.tabs.AssetTab
import org.example.project.presentation.tabs.DebtTab
import org.example.project.presentation.tabs.HomeTab
import org.example.project.presentation.tabs.ProfileTab
import org.example.project.presentation.tabs.SocialTab

@Composable
fun TabItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(MaterialTheme.colorScheme.surface),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BottomBarItem(DebtTab, tabNavigator)
        BottomBarItem(AssetTab, tabNavigator)
        BottomBarItem(HomeTab, tabNavigator)
        BottomBarItem(SocialTab, tabNavigator)
        BottomBarItem(ProfileTab, tabNavigator)

    }
}

@Composable
fun BottomBarItem(
    tab: Tab,
    tabNavigator: TabNavigator
) {
    val selected = tabNavigator.current == tab

    Column(
        modifier = Modifier
            .clickable { tabNavigator.current = tab }
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        tab.options.icon?.let {
            Icon(
                painter = it,
                contentDescription = tab.options.title,
                tint = if (selected)
                    MaterialTheme.colorScheme.primary
                else
                    MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
            )
        }

        Text(
            text = tab.options.title,
            fontSize = 12.sp,
            color = if (selected)
                MaterialTheme.colorScheme.primary
            else
                MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
        )
    }
}
