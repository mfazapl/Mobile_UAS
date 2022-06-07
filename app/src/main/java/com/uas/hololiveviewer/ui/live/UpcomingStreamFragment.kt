package com.uas.hololiveviewer.ui.live

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.uas.hololiveviewer.databinding.FragmentUpcomingStreamBinding
import com.google.android.material.divider.MaterialDividerItemDecoration
import com.uas.hololiveviewer.R

class UpcomingStreamFragment : Fragment() {
    private val viewModel: UpcomingStreamViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentUpcomingStreamBinding.inflate(inflater)
        viewModel.getHololiveData()
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.rvUpcoming.adapter = UpcomingStreamAdapter(UpcomingListener { holo ->
            viewModel.onHololiveItemClicked(holo)
            findNavController()
                .navigate(R.id.action_nav_home_to_upcomingStreamDetailFragment)
        })

        (activity as AppCompatActivity).supportActionBar?.title = "Upcoming Stream List"
        binding.rvUpcoming.addItemDecoration(
            MaterialDividerItemDecoration(
                requireContext(),
                LinearLayoutManager.VERTICAL
            )
        )

        return binding.root
    }
}