package com.uas.hololiveviewer.data.video

data class DataVideo(
  
    @Json(name="count")
    val count: Int? = null,

    @Json(name="total")
    val total: Int? = null,

    @Json(name = "videos")
    val videos: List<Video>? = null
)
