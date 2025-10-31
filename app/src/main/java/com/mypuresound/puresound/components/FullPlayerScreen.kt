package com.mypuresound.puresound.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mypuresound.puresound.R

@Composable
fun FullPlayerScreen(onClose: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("🎵 Tocando agora", style = MaterialTheme.typography.titleMedium)
        Spacer(Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.capadebanda),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(16.dp))
        )
        Spacer(Modifier.height(24.dp))
        Text("Over the Horizon", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(8.dp))
        Text("Samsung - Brand Music", style = MaterialTheme.typography.bodyMedium)
        Spacer(Modifier.height(24.dp))
        Slider(value = 0.4f, onValueChange = {})
        Spacer(Modifier.height(24.dp))
        Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
            IconButton(onClick = {}) { Icon(painter = painterResource(R.drawable.previous), null) }
            IconButton(onClick = {}) { Icon(painter = painterResource(R.drawable.play_button), null, modifier = Modifier.size(64.dp)) }
            IconButton(onClick = {}) { Icon(painter = painterResource(R.drawable.next_button), null) }
        }
        Spacer(Modifier.height(24.dp))
        Button(onClick = onClose) {
            Text("Fechar")
        }
    }
}