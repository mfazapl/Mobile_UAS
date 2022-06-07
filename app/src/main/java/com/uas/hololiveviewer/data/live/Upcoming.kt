package com.uas.hololiveviewer.data.live

import com.squareup.moshi.Json

data class Upcoming(

    @Json(name="bb_video_id")
    val bbVideoId: Any? = null,

    @Json(name="thumbnail")
    val thumbnail: Any? = null,

    @Json(name="live_viewers")
    val liveViewers: Any? = null,

    @Json(name="yt_video_key")
    val ytVideoKey: String? = null,

    @Json(name="channel")
    val channel: Channel? = null,

    @Json(name="live_schedule")
    val liveSchedule: String? = null,

    @Json(name="id")
    val id: Int? = null,

    @Json(name="live_start")
    val liveStart: Any? = null,

    @Json(name="title")
    val title: String? = null,

    @Json(name="live_end")
    val liveEnd: Any? = null,

    @Json(name="status")
    val status: String? = null
)