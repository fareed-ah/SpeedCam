package com.android.speedcam

import android.app.Application
import com.android.speedcam.database.AppDatabase

class CameraApplication: Application() {
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }

}