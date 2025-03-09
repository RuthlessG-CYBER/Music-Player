package com.example.musicplayer

import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay


//Music Card //Top Playlists Cards //Favourite Cards

//Music Card
@Composable
fun MusicCard(music: MusicList) {
    OutlinedCard(onClick = {},
        modifier = Modifier
            .height(90.dp)
            .padding(start = 5.dp, end = 5.dp, bottom = 2.dp, top = 2.dp)
            .width(350.dp).border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(20.dp)),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp,
            pressedElevation = 5.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = androidx.compose.ui.graphics.Color(0xFFa5a4a3)
        ),
        shape = RoundedCornerShape(20.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()){
            Row(modifier = Modifier
                .padding(start = 10.dp, end = 10.dp)
                .align(Alignment.CenterStart)){
                Card(modifier = Modifier,
                    shape = RoundedCornerShape(20.dp)
                    ){
                    Image(painter = painterResource(id = music.image),
                        contentDescription = "Banner",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(60.dp)
                            .width(60.dp)
                    )
                }

                Spacer(modifier = Modifier.width(20.dp))
                Column(modifier = Modifier.width(150.dp).align(Alignment.CenterVertically)){
                    Text(
                        text = music.songName,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                    Text(
                        text = music.artistName,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                }

                Spacer(modifier = Modifier.weight(1f))
                TextButton(onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = androidx.compose.ui.graphics.Color.White,
                        contentColor = androidx.compose.ui.graphics.Color.Black
                    ),
                    modifier = Modifier.align(Alignment.CenterVertically)
                    ) {
                    Icon(imageVector = Icons.Default.PlayArrow, contentDescription = "Play")
                    Text(text = "Play")
                }
            }
        }
    }
}

//Top Playlists Card
@Composable
fun TopPlaylists(){
    Box(modifier = Modifier
        .height(230.dp)
        .fillMaxWidth(),
    ){
        LazyHorizontalGrid(
            rows = GridCells.Fixed(3),
            modifier = Modifier.fillMaxSize()
        ) {
            items(musicList) { music ->
                MusicCard(music)
            }
        }
    }
}

//Favourite Cards
@Composable
fun FavouriteCard(){
    val scrollState = rememberScrollState()

    LaunchedEffect(Unit) {
        while (true) {
            delay(10000)
            scrollState.animateScrollTo(scrollState.maxValue, animationSpec = tween(1000))
            delay(5000)
            scrollState.animateScrollTo(0, animationSpec = tween(1000))
        }
    }

    Row(
        modifier = Modifier
            .horizontalScroll(scrollState)
    ) {
        repeat(2) {
            CardBox()
        }
    }
}



//Favourite Card inside Music Cards
@Composable
fun CardBox() {
    ElevatedCard(
        modifier = Modifier
            .width(390.dp)
            .height(270.dp)
            .padding(start = 5.dp, end = 5.dp)
            .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(10.dp)),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFa5a4a3))
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            ElevatedCard(modifier = Modifier.height(120.dp).width(175.dp).align(Alignment.TopStart),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                shape = RoundedCornerShape(10.dp)){
                Box {
                    Image(
                        painter = painterResource(id = R.drawable.banner_1),
                        contentDescription = "Banner",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                    )
                    TextButton(onClick = {},
                        modifier = Modifier.height(35.dp).align(Alignment.TopStart),
                        ){
                        Icon(Icons.Default.PlayArrow,
                            contentDescription = "Play",
                            modifier = Modifier,
                            tint = Color.White,
                        )
                        Text(text = "Play", color = Color.White)
                    }
                }
            }
            ElevatedCard(modifier = Modifier.height(120.dp).width(175.dp).align(Alignment.TopEnd),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                shape = RoundedCornerShape(10.dp)){
                Box {
                    Image(
                        painter = painterResource(id = R.drawable.banner_2),
                        contentDescription = "Banner",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                    )
                    TextButton(onClick = {},
                        modifier = Modifier.height(35.dp).align(Alignment.TopStart),
                    ){
                        Icon(Icons.Default.PlayArrow,
                            contentDescription = "Play",
                            modifier = Modifier,
                            tint = Color.White,
                        )
                        Text(text = "Play", color = Color.White)
                    }
                }
            }
            ElevatedCard(modifier = Modifier.height(120.dp).width(175.dp).align(Alignment.BottomStart),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                shape = RoundedCornerShape(10.dp)){
                Box {
                    Image(
                        painter = painterResource(id = R.drawable.banner_3),
                        contentDescription = "Banner",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                    )
                    TextButton(onClick = {},
                        modifier = Modifier.height(35.dp).align(Alignment.TopStart),
                    ){
                        Icon(Icons.Default.PlayArrow,
                            contentDescription = "Play",
                            modifier = Modifier,
                            tint = Color.White,
                        )
                        Text(text = "Play", color = Color.White)
                    }
                }
            }
            ElevatedCard(modifier = Modifier.height(120.dp).width(175.dp).align(Alignment.BottomEnd),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                shape = RoundedCornerShape(10.dp)){
                Box {
                    Image(
                        painter = painterResource(id = R.drawable.banner_4),
                        contentDescription = "Banner",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                    )
                    TextButton(onClick = {},
                        modifier = Modifier.height(35.dp).align(Alignment.TopStart),
                    ){
                        Icon(Icons.Default.PlayArrow,
                            contentDescription = "Play",
                            modifier = Modifier,
                            tint = Color.White,
                        )
                        Text(text = "Play", color = Color.White)
                    }
                }
            }
        }
    }
}

@Composable
fun Playlist(){
    val scrollState = rememberScrollState()

    Row(modifier = Modifier
        .horizontalScroll(scrollState)){
        repeat(5) {
            PlayListCard(music = musicList[it])
        }
    }
}

@Composable
fun PlayListCard(music: MusicList){
    ElevatedCard(onClick = {},
        modifier = Modifier
            .height(190.dp)
            .width(150.dp)
            .padding(start = 5.dp),
    ){
        Card(modifier = Modifier.height(140.dp).width(150.dp)){
            Image(painter = painterResource(music.image),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
        }
        Text(text = "PUNK Music",
            modifier = Modifier.padding(start = 10.dp, top = 5.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
        Text(text = "51 Songs",
            modifier = Modifier.padding(start = 10.dp, top = 5.dp),
            fontSize = 12.sp
        )
    }
}


