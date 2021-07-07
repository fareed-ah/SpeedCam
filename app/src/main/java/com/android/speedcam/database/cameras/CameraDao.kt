package com.android.speedcam.database.cameras

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CameraDao {
    @Query("SELECT * FROM camera ORDER BY city_name ASC")
    fun getAllCameras(): List<Camera>

    @Insert
    fun addCamera(newCamera: Camera)

    @Insert
    fun addCameras(cameraList: List<Camera>)
}