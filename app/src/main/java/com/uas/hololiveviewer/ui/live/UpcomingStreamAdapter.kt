package com.uas.hololiveviewer.ui.live

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.uas.hololiveviewer.data.live.Upcoming
import com.uas.hololiveviewer.databinding.UpcomingStreamItemBinding

class UpcomingStreamAdapter(private val clickListener: UpcomingListener):
    ListAdapter<Upcoming, UpcomingStreamAdapter.UpcomingViewHolder>(DiffCallback) {
    class UpcomingViewHolder(
        var binding: UpcomingStreamItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(clickListener: UpcomingListener, hololive: Upcoming) {
            binding.holoItem = hololive
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Upcoming>() {
        override fun areItemsTheSame(oldItem: Upcoming, newItem: Upcoming): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Upcoming, newItem: Upcoming): Boolean {
            return oldItem.title == newItem.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return UpcomingViewHolder(
            UpcomingStreamItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: UpcomingViewHolder, position: Int) {
        val holo = getItem(position)
        holder.bind(clickListener, holo)
    }

}

class UpcomingListener(val clickListener: (holo: Upcoming) -> Unit) {
    fun onClick(holo: Upcoming) = clickListener(holo)
}