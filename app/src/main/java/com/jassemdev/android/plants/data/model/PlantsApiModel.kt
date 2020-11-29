package com.jassemdev.android.plants.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
data class PlantsApiModel(val data: List<Plant>)

@JsonClass(generateAdapter = true)
data class PlantItemApiModel(val data: Plant)

@Parcelize
@JsonClass(generateAdapter = true)
data class Plant(
        val id: Long,
        val author: String?,
        val bibliography: String?,
        @Json(name = "common_name") val name: String?,
        @Json(name = "image_url") val imageUrl: String?,
        @Json(name = "scientific_name") val scientificName: String,
        val slug: String,
        val year: String?,
        val rank: String,
        @Json(name = "family_common_name") val familyName: String,
        val family: String,
        val genus: String
) : Parcelable
