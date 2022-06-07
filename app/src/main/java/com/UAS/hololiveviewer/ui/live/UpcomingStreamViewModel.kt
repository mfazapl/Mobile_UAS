package com.UAS.hololiveviewer.ui.live

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.UAS.hololiveviewer.data.live.ChannelUpcoming
import com.UAS.hololiveviewer.data.live.Upcoming
import com.UAS.hololiveviewer.network.HoloApi
import kotlinx.coroutines.launch

enum class HololiveApiStatus { LOADING, ERROR, DONE }
class UpcomingStreamViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }


    private val _status = MutableLiveData<HololiveApiStatus>()
    val status: LiveData<HololiveApiStatus> = _status

    private val _hololiveUpcomings = MutableLiveData<List<Upcoming>?>()
    val hololiveUpcomings: MutableLiveData<List<Upcoming>?> = _hololiveUpcomings

    private val _hololiveUpcoming = MutableLiveData<Upcoming>()
    val hololiveUpcoming: LiveData<Upcoming> = _hololiveUpcoming

    private val _upcomingVideo = MutableLiveData<List<ChannelUpcoming>?>()
    val upcomingVideo: MutableLiveData<List<ChannelUpcoming>?> = _upcomingVideo


    val text: LiveData<String> = _text

    fun getHololiveData() {
        viewModelScope.launch {
            _status.value = HololiveApiStatus.LOADING
            try {
                _hololiveUpcomings.value = HoloApi.retrofitService.getDataUpcoming().upcoming
                _status.value = HololiveApiStatus.DONE
            } catch (e: Exception) {
                _status.value = HololiveApiStatus.ERROR
                _hololiveUpcomings.value = listOf()
                e.message?.let { Log.i("Pesan Error", it) }
            }
        }
    }

    fun onHololiveItemClicked(holo: Upcoming) {
        _hololiveUpcoming.value = holo
    }
}