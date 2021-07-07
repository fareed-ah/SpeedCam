package com.android.speedcam.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://511on.ca/api/v2/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface CameraApiService {
    @GET("get/cameras")
    suspend fun getCameras(): List<Camera>
}

object CameraApi {
    val retrofitService : CameraApiService by lazy {
        retrofit.create(CameraApiService::class.java)
    }
}