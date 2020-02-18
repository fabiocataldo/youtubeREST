package com.example.kotlinyoutube

import com.google.gson.annotations.SerializedName

data class HomeFeed(
    val videos: List<Video>
)

data class Video(
    val channel: Channel,
    val imageUrl: String,
    @SerializedName("name")
    val nameExample: String
)

data class Channel(
    val name: String,
    val profileImageUrl: String
)
