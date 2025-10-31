package com.mypuresound.puresound.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.mypuresound.puresound.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarWithTabs(
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit
) {
    Column {
        TopAppBar(
            title = {
                Text(
                    text = "PureSound"
                )
            },
            actions = {
                IconButton(onClick = { /* buscar */ }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_action_search),
                        contentDescription = null
                    )
                }
                IconButton(onClick = { /* configurações */ }) {
                    Icon(
                        painterResource(R.drawable.ic_action_settings),
                        contentDescription = null
                    )
                }
            }
        )

        // --- Abas (Tabs) ---
        val tabs = listOf("Músicas", "Playlists", "Pastas", "Artistas")

        TabRow(selectedTabIndex = selectedTabIndex) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { onTabSelected(index) },
                    text = { Text(title) }
                )
            }
        }
    }
}