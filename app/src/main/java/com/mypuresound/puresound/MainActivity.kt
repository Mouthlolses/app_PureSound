package com.mypuresound.puresound

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.net.toUri
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.mypuresound.puresound.ui.theme.PureSoundTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PureSoundTheme {
                Scaffold(
                    modifier = Modifier.Companion
                        .statusBarsPadding()
                        .navigationBarsPadding()
                ) { innerPadding ->
                    Greeting(
                        modifier = Modifier.Companion
                            .padding(innerPadding)
                            .background(Color.Companion.Black)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier.Companion) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Companion.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        VideoPlayer()
    }

}

@Composable
fun VideoPlayer() {
    val context = LocalContext.current
    val videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
    val musicUrl = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3"

    val player = remember {
        ExoPlayer.Builder(context).build().apply {
            val mediaItem = MediaItem.fromUri(videoUrl.toUri())
            val secondMediaItem = MediaItem.fromUri(musicUrl.toUri())
            setMediaItem(mediaItem)
            addMediaItem(secondMediaItem)
            prepare()
            playWhenReady = false
        }
    }

    AndroidView(
        factory = {
            PlayerView(it).apply {
                this.player = player
            }
        },
        modifier = Modifier.Companion.fillMaxSize()
    )
    DisposableEffect(Unit) {
        onDispose {
            player.release()
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PureSoundTheme {

    }
}