package com.uas.hololiveviewer.data.video

data class ChannelVideo(
     @Json (name="bb_space_id")
    val bb_space_id: Any? = null,

    @Json (name="description")
    val description: String? = null,

    @Json (name="id")
    val id: Int? = null,

    @Json (name="name")
    val name: String? = null,

    @Json (name="photo")
    val photo: String? = null,

    @Json (name="published_at")
    val published_at: String? = null,

    @Json (name="sucbcriber_count")
    val subscriber_count: Int? = null,

    @Json (name="twitter_link")
    val twitter_link: String? = null,

    @Json (name="video_count")
    val video_count: Int? = null,

    @Json(name="view_count")
    val view_count: Int? = null,

    @Json(name="yt_channel_id")
    val yt_channel_id: String? = null
)
