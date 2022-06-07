package com.uas.hololiveviewer

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.uas.hololiveviewer.data.live.Upcoming
import com.uas.hololiveviewer.ui.live.HololiveApiStatus
import com.uas.hololiveviewer.ui.live.UpcomingStreamAdapter

@BindingAdapter("listUpcoming")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Upcoming>?) {
    val adapter = recyclerView.adapter as UpcomingStreamAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}

@BindingAdapter("hololiveApiStatus")
fun bindStatus(statusImageView: ImageView, status: HololiveApiStatus?) {
    when (status) {
        HololiveApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        HololiveApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        HololiveApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}