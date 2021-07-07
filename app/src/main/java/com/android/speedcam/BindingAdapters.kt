package com.android.speedcam

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.speedcam.network.Camera
import com.android.speedcam.ui.cameralist.CameraAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Camera>?) {
    val adapter = recyclerView.adapter as CameraAdapter
    adapter.submitList(data)
}
