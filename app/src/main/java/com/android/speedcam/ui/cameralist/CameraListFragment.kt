package com.android.speedcam.ui.cameralist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.android.speedcam.databinding.FragmentCameraListBinding
import com.android.speedcam.viewmodels.CameraViewModel

class CameraListFragment : Fragment() {

    private val viewModel: CameraViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCameraListBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.recyclerView.adapter = CameraAdapter {}
        return binding.root
    }

}