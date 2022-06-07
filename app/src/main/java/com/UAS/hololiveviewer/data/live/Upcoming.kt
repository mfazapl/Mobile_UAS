package com.UAS.hololiveviewer.data.live

data class Upcoming(
    val bb_video_id: Any,
    val channel: ChannelUpcoming,
    val id: Int,
    val live_end: Any,
    val live_schedule: String,
    val live_start: Any,
    val live_viewers: Any,
    val status: String,
    val thumbnail: Any,
    val title: String,
    val yt_video_key: String
)