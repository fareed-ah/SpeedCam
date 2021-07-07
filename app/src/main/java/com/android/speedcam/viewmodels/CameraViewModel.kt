package com.android.speedcam.viewmodels

import androidx.lifecycle.*
import com.android.speedcam.network.Camera
import com.android.speedcam.network.CameraApi
import kotlinx.coroutines.launch

class CameraViewModel :ViewModel() {

    private val _cameras = MutableLiveData<List<Camera>>()

    val cameras: LiveData<List<Camera>> = _cameras

    init{
        print("INIT:")
        getAllCameras()
    }

//    fun allCameras():List<Camera> = cameraDao.getAllCameras()

    private fun getAllCameras() {
        viewModelScope.launch {
            _cameras.value = CameraApi.retrofitService.getCameras()
            print("CAMERA OUTPUT:")
            _cameras.value!!.forEach { print(it.cityName) }
        }
    }
}

//class CameraViewModelFactory(
//    private val cameraDao: CameraDao
//) : ViewModelProvider.Factory {
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(CameraViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST")
//            return CameraViewModel(cameraDao) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}