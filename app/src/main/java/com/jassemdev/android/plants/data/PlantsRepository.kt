package com.jassemdev.android.plants.data

import com.jassemdev.android.plants.data.model.PlantsApiModel

interface PlantsRepository {
    suspend fun getPlants(): PlantsApiModel
}