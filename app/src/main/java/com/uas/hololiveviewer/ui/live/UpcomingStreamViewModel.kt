package com.uas.hololiveviewer.ui.live

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uas.hololiveviewer.data.live.Upcoming
import com.uas.hololiveviewer.network.HoloApi
import kotlinx.coroutines.launch

enum class HololiveApiStatus { LOADING, ERROR, DONE }
class UpcomingStreamViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }


    private val _status = MutableLiveData<HololiveApiStatus>()
    val status: LiveData<HololiveApiStatus> = _status

    private var _hololiveUpcomings = MutableLiveData<List<Upcoming>?>()
    val hololiveUpcomings: MutableLiveData<List<Upcoming>?> = _hololiveUpcomings

    private var _hololiveUpcoming = MutableLiveData<Upcoming>()
    val hololiveUpcoming: LiveData<Upcoming> = _hololiveUpcoming


    val text: LiveData<String> = _text

    var pesanError: String = "TEXT"

    init {
        getHololiveData()
    }

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