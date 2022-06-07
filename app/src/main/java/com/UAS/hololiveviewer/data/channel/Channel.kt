package com.UAS.hololiveviewer.data.channel

data class Channel(
    val bb_space_id: Any,
    val description: String,
    val id: Int,
    val name: String,
    val photo: String,
    val published_at: String,
    val subscriber_count: Int,
    val twitter_link: String,
    val video_count: Int,
    val video_original: Int,
    val view_count: Int,
    val yt_channel_id: String
)