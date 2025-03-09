package com.example.musicplayer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MusicPlayer(music: MusicList) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFa5a4a3),
                        Color(0xFF7c7a79)
                    )
                )
            )
    ) {
        // Scrollable Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(top = 40.dp)
        ) {
            // Bar
            OutlinedCard(
                modifier = Modifier
                    .height(60.dp)
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp)
                    .shadow(5.dp, shape = CardDefaults.elevatedShape),
                colors = CardDefaults.cardColors(
                    containerColor = Color.LightGray
                )
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 20.dp, end = 20.dp)
                ) {
                    Icon(
                        Icons.Default.Menu,
                        contentDescription = "Menu",
                        modifier = Modifier
                            .size(35.dp)
                            .align(Alignment.CenterEnd)
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

            Spacer(modifier = Modifier.height(10.dp))

            // Top Playlists
            Text(
                text = "Top Playlists",
                modifier = Modifier.padding(start = 10.dp),
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontFamily = androidx.compose.ui.text.font.FontFamily.Cursive,
                letterSpacing = 2.sp
            )
            Spacer(Modifier.height(10.dp))

            // Playlist Cards
            TopPlaylists()

            Spacer(modifier = Modifier.height(10.dp))

            // Favourites
            Text(
                text = "Favourite",
                modifier = Modifier.padding(start = 10.dp),
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = androidx.compose.ui.text.font.FontFamily.Cursive,
                letterSpacing = 2.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Favourite Cards
            FavouriteCard()

            Spacer(modifier = Modifier.height(10.dp))

            //Favourite PlayList
            Text(
                text = "PlayLists",
                modifier = Modifier.padding(start = 10.dp),
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = androidx.compose.ui.text.font.FontFamily.Cursive,
                letterSpacing = 2.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            //Playlist
            Playlist()

            Spacer(modifier = Modifier.height(100.dp))
        }

        // Floating Music Player
        ElevatedCard(onClick = {},
            modifier = Modifier
                .height(80.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 15.dp, start = 10.dp, end = 10.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFa5a19e)
            ),
            shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp, bottomStart = 20.dp, bottomEnd = 20.dp)
            ){
            Box(modifier = Modifier.fillMaxSize()){
                Row(modifier = Modifier.fillMaxSize().padding(end = 5.dp)){
                    Column(modifier = Modifier
                        .width(240.dp)
                        .align(Alignment.CenterVertically)
                        .padding(start = 10.dp)){
                        Text(text = music.songName,
                            modifier = Modifier.padding(start = 10.dp),
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Text(text = music.artistName,
                            modifier = Modifier.padding(start = 10.dp)
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(Icons.Default.KeyboardArrowLeft,
                        contentDescription = "Previous Song",
                        modifier = Modifier.align(Alignment.CenterVertically).padding(end = 10.dp).size(30.dp)
                    )

                    Icon(Icons.Default.PlayArrow,
                        contentDescription = "Play",
                        modifier = Modifier.align(Alignment.CenterVertically).padding(end = 10.dp).size(35.dp)
                    )

                    Icon(Icons.Default.KeyboardArrowRight,
                        contentDescription = "Next Song",
                        modifier = Modifier.align(Alignment.CenterVertically).padding(end = 10.dp).size(30.dp)
                    )
                }
            }
        }
    }
}
