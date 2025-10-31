package com.mypuresound.puresound.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarWithTabs(
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit
) {
    Column {
        CenterAlignedTopAppBar(
            title = { Text("PureSound") },
            navigationIcon = {
                IconButton(onClick = { /* abrir menu lateral, se tiver */ }) {
                    Icon(Icons.Default.Menu, contentDescription = "Menu")
                }
            },
            actions = {
                IconButton(onClick = { /* buscar */ }) {
                    Icon(Icons.Default.Search, contentDescription = "Buscar")
                }
                IconButton(onClick = { /* configurações */ }) {
                    Icon(Icons.Default.Settings, contentDescription = "Configurações")
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