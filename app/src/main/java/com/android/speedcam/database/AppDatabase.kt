package com.android.speedcam.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.android.speedcam.database.cameras.Camera
import com.android.speedcam.database.cameras.CameraDao

@Database(entities = arrayOf(Camera::class), version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun cameraDao(): CameraDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database")
                    .createFromAsset("database/camera.db")
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}