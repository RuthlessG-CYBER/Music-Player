package com.example.musicplayer

data class MusicList(
    val image: Int,
    val songName: String,
    val artistName: String
)

val imageList = listOf(
    R.drawable.banner_1,
    R.drawable.banner_2,
    R.drawable.banner_3,
    R.drawable.banner_4,
    R.drawable.banner_5
)

val musicList = listOf(
    MusicList(imageList[0], "Heart over Mind", "Alan Walker & Daya"),
    MusicList(imageList[1], "Who I Am", "Alan Walker, Putri Ariani"),
    MusicList(imageList[2], "Loop", "Kaushik Pathak"),
    MusicList(imageList[3], "Legends Never Die", "Youth Never Dies"),
    MusicList(imageList[4], "Unstoppable", "Sia"),
    MusicList(imageList[1], "Ina Wroldsen - Strongest (Alan Walker Remix)", "Ina Wroldsen"),
    MusicList(imageList[3], "Hall of Fame (feat. will.i.am)", "The Script"),
    MusicList(imageList[2], "Die With A Smile", "Lady Gaga Bruno Marsn"),
)