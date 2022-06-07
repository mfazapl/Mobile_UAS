package com.uas.hololiveviewer.data.live

import com.squareup.moshi.Json

data class DataUpcomingStream(

	@Json(name="upcoming")
	val upcoming: List<Upcoming>? = null
)
