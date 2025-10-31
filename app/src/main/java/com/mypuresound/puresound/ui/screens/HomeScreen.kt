package com.mypuresound.puresound.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mypuresound.puresound.R

@Composable
fun HomeScreen(modifier: Modifier) {

    val musics = listOf(
        "Te Quero",
        "Desejo você",
        "Sleepwalking",
        "Doomed",
        "Caraphernelia",
        "King for a Day",
        "Smells Like Teen Spirit",
        "Heart-Shaped Box",
        "About a Girl",
        "All Apologies",
        "Lithium",
        "In Bloom",
        "Something in the Way",
        "Serve the Servants",
        "Pennyroyal Tea"
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(15) {
            Card() {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(86.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_launcher_foreground),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(color = Color.Green)
                    )
                    Spacer(modifier = Modifier.padding(12.dp))
                    Text(
                        text = musics.random(),
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                    )
                }
            }
        }
    }
}