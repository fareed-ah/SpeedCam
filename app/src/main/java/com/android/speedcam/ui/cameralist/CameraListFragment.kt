package com.android.speedcam.ui.cameralist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.android.speedcam.R
import com.android.speedcam.databinding.FragmentCameraListBinding
import com.android.speedcam.viewmodels.CameraViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CameraListFragment : Fragment() {

    private val viewModel: CameraViewModel by hiltNavGraphViewModels(R.id.nav_graph_xml)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCameraListBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
        binding.recyclerView.adapter = CameraAdapter {}
        return binding.root
    }

}