package com.android.speedcam.database.cameras

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Camera(
    @PrimaryKey val id: Int,
    @NonNull @ColumnInfo(name = "organization") val organization: String,
    @NonNull @ColumnInfo(name = "roadway_name") val roadwayName: String,
    @NonNull @ColumnInfo(name = "latitude") val latitude: Double,
    @NonNull @ColumnInfo(name = "longitude") val longitude: Double,
    @NonNull @ColumnInfo(name = "name") val name: String,
    @NonNull @ColumnInfo(name = "url") val url: String,
    @NonNull @ColumnInfo(name = "status") val status: String,
    @NonNull @ColumnInfo(name = "description") val description: String,
    @NonNull @ColumnInfo(name = "city_name") val cityName: String,

)