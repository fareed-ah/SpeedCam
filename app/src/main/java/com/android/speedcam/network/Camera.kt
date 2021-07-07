package com.android.speedcam.network

import com.squareup.moshi.Json

data class Camera(
    @Json(name = "Id") val id: String,
    @Json(name = "Organization") val organization: String,
    @Json(name = "RoadwayName") val roadwayName: String?,
    @Json(name = "Latitude") val latitude: Double,
    @Json(name = "Longitude") val longitude: Double,
    @Json(name = "Name") val name: String,
    @Json(name = "Url") val url: String,
    @Json(name = "Status") val status: String,
    @Json(name = "Description") val description: String,
    @Json(name = "CityName") val cityName: String,
)