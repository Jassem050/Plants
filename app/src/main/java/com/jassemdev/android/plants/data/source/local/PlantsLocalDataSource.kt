package com.jassemdev.android.plants.data.source.local

import com.jassemdev.android.plants.data.PlantsDataSource
import com.jassemdev.android.plants.data.model.PlantsApiModel
import javax.inject.Inject


class PlantsLocalDataSource @Inject constructor(): PlantsDataSource {
    override suspend fun getPlants(): PlantsApiModel {
        TODO("Not yet implemented")
    }
}