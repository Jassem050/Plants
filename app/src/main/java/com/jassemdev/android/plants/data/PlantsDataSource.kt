package com.jassemdev.android.plants.data

import com.jassemdev.android.plants.data.model.PlantsApiModel

interface PlantsDataSource {

    suspend fun getPlants(): PlantsApiModel
}