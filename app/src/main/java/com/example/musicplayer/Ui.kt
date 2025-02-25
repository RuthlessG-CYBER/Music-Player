package com.example.musicplayer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MusicPlayer(){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(brush = Brush.verticalGradient(
            colors = listOf(
                Color.LightGray,
                Color.Black
            )
        ))){

        //Top Bar Items
        Column(modifier = Modifier.padding(top = 40.dp)){
            OutlinedCard(modifier = Modifier
                .height(60.dp)
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
                .shadow(5.dp, shape = CardDefaults.elevatedShape),
                colors = CardDefaults.cardColors(
                    containerColor = Color.LightGray
                ))
            {
                Box(modifier = Modifier.fillMaxSize().padding(start = 20.dp, end = 20.dp)){
                    Icon(Icons.Default.Menu, contentDescription = "Menu",
                        modifier = Modifier.height(35.dp).width(35.dp).align(Alignment.CenterEnd)
                    )
                    Text(
                        text = "Panda Player",
                        modifier = Modifier.align(Alignment.CenterStart),
                        fontSize = 20.sp,
                        fontFamily = androidx.compose.ui.text.font.FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.sp
                    )
                }
            }

            //A Gap between Top Bar and Playlist
            Spacer(modifier = Modifier.height(10.dp))

            //Top Playlists
            Text(
                text="Top Playlists",
                modifier = Modifier.padding(start = 10.dp),
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontFamily = androidx.compose.ui.text.font.FontFamily.Cursive,
                letterSpacing = 2.sp
            )
            Spacer(Modifier.height(10.dp))

            //Playlist Cards
            TopPlaylists()

            Spacer(modifier = Modifier.height(10.dp))

            //Favourites
            Text(
                text="Favourite",
                modifier = Modifier.padding(start = 10.dp),
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = androidx.compose.ui.text.font.FontFamily.Cursive,
                letterSpacing = 2.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            //Favourite Cards

        }
    }
}