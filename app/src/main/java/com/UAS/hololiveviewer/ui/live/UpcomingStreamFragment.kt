package com.UAS.hololiveviewer.ui.live

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.UAS.hololiveviewer.R
import com.UAS.hololiveviewer.databinding.FragmentUpcomingStreamBinding
import com.google.android.material.divider.MaterialDividerItemDecoration

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

        //@TODO
        //rv on click -> into detail

        (activity as AppCompatActivity).supportActionBar?.title = "Upcoming Stream List"
        binding.rv.addItemDecoration(
            MaterialDividerItemDecoration(
                requireContext(),
                LinearLayoutManager.VERTICAL
            )
        )

        return binding.root
    }
}