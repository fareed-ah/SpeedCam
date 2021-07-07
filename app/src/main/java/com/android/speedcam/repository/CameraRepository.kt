package com.android.speedcam.repository

import com.android.speedcam.network.CameraApi
import javax.inject.Inject

class CameraRepository @Inject constructor() {
    suspend fun getCameras() = CameraApi.retrofitService.getCameras()
}