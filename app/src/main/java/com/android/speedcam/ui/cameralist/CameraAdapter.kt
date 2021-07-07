package com.android.speedcam.ui.cameralist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.speedcam.databinding.CameraItemBinding
import com.android.speedcam.network.Camera

class CameraAdapter(private val onItemClicked: (Camera) -> Unit):
    ListAdapter<Camera, CameraViewHolder>(DiffCallback) {

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Camera>() {
            override fun areItemsTheSame(oldItem: Camera, newItem: Camera): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Camera, newItem: Camera): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CameraViewHolder {
       val viewHolder = CameraViewHolder(
            CameraItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
       )
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            onItemClicked(getItem(position))
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: CameraViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class CameraViewHolder(private var binding: CameraItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(camera: Camera) {
       binding.camera  =camera
        binding.executePendingBindings()
    }
}