package com.mypuresound.puresound

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mypuresound.puresound.components.AudioPlayer
import com.mypuresound.puresound.components.FullPlayerScreen
import com.mypuresound.puresound.components.TopBarWithTabs
import com.mypuresound.puresound.ui.screens.HomeScreen
import com.mypuresound.puresound.ui.screens.PastaScreen
import com.mypuresound.puresound.ui.screens.PlayListScreen
import com.mypuresound.puresound.ui.theme.PureSoundTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PureSoundTheme {
                var selectedTab by remember { mutableIntStateOf(0) }
                var showFullPlayer by remember { mutableStateOf(false) }

                Scaffold(
                    modifier = Modifier
                        .statusBarsPadding()
                        .navigationBarsPadding(),
                    topBar = {
                        TopBarWithTabs(
                            selectedTabIndex = selectedTab,
                            onTabSelected = { selectedTab = it }
                        )
                    },
                    bottomBar = {
                        if (!showFullPlayer) {
                            BottomAppBar(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { showFullPlayer = true }
                            ) {
                                AudioPlayer(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 8.dp, vertical = 4.dp)
                                )
                            }
                        }
                    }
                ) { paddingValues ->
                    Box(modifier = Modifier.padding(paddingValues)) {
                        when (selectedTab) {
                            0 -> HomeScreen(modifier = Modifier)
                            1 -> PlayListScreen()
                            2 -> PastaScreen()
                            3 -> PlayListScreen()
                        }

                        if (showFullPlayer) {
                            ModalBottomSheet(
                                onDismissRequest = { showFullPlayer = false },
                                containerColor = Color.Gray
                            ) {
                                FullPlayerScreen()
                            }
                        }

                    }
                }
            }
        }
    }
}