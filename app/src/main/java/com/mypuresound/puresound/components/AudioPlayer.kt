package com.mypuresound.puresound.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.mypuresound.puresound.R
import kotlinx.coroutines.delay

@Composable
fun AudioPlayer(
    audioUrl: String = "https://storage.googleapis.com/exoplayer-test-media-0/play.mp3",
    modifier: Modifier
) {
    val context = LocalContext.current

    // Player configurado uma única vez
    val player = remember {
        ExoPlayer.Builder(context).build().apply {
            setMediaItem(MediaItem.fromUri(audioUrl))
            prepare()
        }
    }

    var isPlaying by remember { mutableStateOf(false) }
    var currentPosition by remember { mutableLongStateOf(0L) }
    var duration by remember { mutableLongStateOf(0L) }

    // Atualiza o progresso continuamente enquanto o player existe
    LaunchedEffect(player) {
        while (true) {
            // Atualiza os valores dentro do snapshot Compose
            currentPosition = player.currentPosition
            duration = player.duration.takeIf { it > 0 } ?: 1L
            delay(500L)
        }
    }

    DisposableEffect(Unit) {
        onDispose { player.release() }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("🎧 Tocando agora", style = MaterialTheme.typography.titleMedium)
        }

        Spacer(Modifier.height(12.dp))

        // Calcula o progresso de 0f a 1f
        val progress = if (duration > 0) currentPosition.toFloat() / duration else 0f

        Slider(
            value = progress.coerceIn(0f, 1f),
            onValueChange = { value ->
                player.seekTo((value * duration).toLong())
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(12.dp))

        IconButton(onClick = {
            if (isPlaying) {
                player.pause()
            } else {
                player.play()
            }
            isPlaying = !isPlaying
        }) {
            Icon(
                painter = if (isPlaying) painterResource(R.drawable.ic_action_play_pause) else painterResource(R.drawable.ic_action_play_arrow),
                contentDescription = "Play/Pause",
                modifier = Modifier.size(64.dp)
            )
        }
    }
}