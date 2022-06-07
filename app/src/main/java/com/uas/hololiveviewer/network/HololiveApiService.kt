package com.uas.hololiveviewer.network

import com.uas.hololiveviewer.data.channel.DataChannel
import com.uas.hololiveviewer.data.video.DataVideo
import  com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.uas.hololiveviewer.data.live.DataUpcomingStream
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.holotools.app/v1/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface HoloApiService {
    @GET("channels")
    suspend fun getDataChannel(): DataChannel


    @GET("videos")
    suspend fun getDataVideo(): DataVideo

    @GET("live")
    suspend fun getDataUpcoming(): DataUpcomingStream

}

object HoloApi {
    val retrofitService: HoloApiService by lazy { retrofit.create(HoloApiService::class.java) }
}