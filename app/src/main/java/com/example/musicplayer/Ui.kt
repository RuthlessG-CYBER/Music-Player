package com.example.musicplayer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MusicPlayer(){
    Box(modifier = Modifier.fillMaxSize().systemBarsPadding()){

        //Top Bar Items
        Column {
            OutlinedCard(modifier = Modifier.height(50.dp).fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color.LightGray
                ))
            {
                Box(modifier = Modifier.fillMaxSize().padding(start = 20.dp, end = 20.dp)){
                    Icon(Icons.Default.Menu, contentDescription = "Menu",
                        modifier = Modifier.height(35.dp).width(35.dp).align(Alignment.CenterEnd)
                    )
                    Text(
                        text = "Music Player",
                        modifier = Modifier.align(Alignment.CenterStart),
                        fontSize = 20.sp
                    )
                }
            }

            //A Gap between Top Bar and Playlist
            Spacer(modifier = Modifier.height(10.dp))

            //Top Playlists
            ElevatedCard(modifier = Modifier.height(200.dp).fillMaxWidth().padding(start = 10.dp, end = 10.dp)) {

            }
        }
    }
}