package com.uas.hololiveviewer.data.video

data class Video(
    val bb_video_id: Any,
    val channel: ChannelVideo,
    val duration_secs: Any,
    val id: Int,
    val is_captioned: Any,
    val is_uploaded: Any,
    val live_end: Any,
    val live_schedule: Any,
    val live_start: Any,
    val published_at: Any,
    val status: String,
    val thumbnail: Any,
    val title: String,
    val yt_video_key: String
)