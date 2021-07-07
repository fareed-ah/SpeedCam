package com.android.speedcam.viewmodels

import androidx.lifecycle.*
import com.android.speedcam.network.Camera
import com.android.speedcam.network.CameraApi
import com.android.speedcam.repository.CameraRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CameraViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val cameraRepository: CameraRepository
) :ViewModel() {

    private val _cameras = MutableLiveData<List<Camera>>()

    val cameras: LiveData<List<Camera>> = _cameras

    init{
        print("INIT:")
        getAllCameras()
    }

    private fun getAllCameras() {
        viewModelScope.launch {
            _cameras.value = cameraRepository.getCameras()
            print("CAMERA OUTPUT:")
            _cameras.value!!.forEach { print(it.cityName) }
        }
    }
}