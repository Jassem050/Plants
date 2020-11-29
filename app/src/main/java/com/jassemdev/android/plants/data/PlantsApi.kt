package com.jassemdev.android.plants.data

import com.jassemdev.android.plants.data.model.PlantItemApiModel
import com.jassemdev.android.plants.data.model.PlantsApiModel
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


private val service: PlantsApi by lazy {
    val okHttpClient = OkHttpClient.Builder()
            .build()

    val moshi = Moshi.Builder()
            .build()

    val retrofit = Retrofit.Builder()
            .baseUrl("https://trefle.io/api/v1/")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    retrofit.create(PlantsApi::class.java)

}

fun getPlantsService() = service

interface PlantsApi {

    @GET("plants")
    suspend fun getPlants(@Query("token") token: String): PlantsApiModel

    @GET("plants")
    suspend fun getPlantsByPage(@Query("page") pageNumber: Int,
                                @Query("token") token: String): PlantsApiModel

    @GET("plants/{id}")
    suspend fun getPlantById(@Path("id") id: Long,
        @Query("token") token: String): PlantItemApiModel
}