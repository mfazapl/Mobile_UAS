package com.uas.hololiveviewer.data.video

data class Video(
 
    @Json(name="bb_video_id")
    val bb_video_id: Any? = null,
    
    @Json(name="channel")
    val channel: ChannelVideo? = null,

    @Json(name="duration_secs")
    val duration_secs: Any? = null,

    @Json(name="id")
    val id: Int? =null,

    @Json(name="is_captioned")
    val is_captioned: Any? = null,

    @Json(name="is_uploaded")
    val is_uploaded: Any? =null,

    @Json(name="live_end")
    val live_end: Any? = null,

    @Json(name="live_schedule")
    val live_schedule: Any? = null,

    @Json(name="live_start")
    val live_start: Any? = null,

    @Json(name="published_at")
    val published_at: Any? = null,

    @Json(name="status")
    val status: String? = null,

    @Json(name="thumbnail")
    val thumbnail: Any? = null,

    @Json(name="title")
    val title: String? = null,

    @Json(name="yt_video_key")
    val yt_video_key: String? = null
)
