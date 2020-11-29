package com.jassemdev.android.plants.data.source

import com.jassemdev.android.plants.data.PlantsDataSource
import com.jassemdev.android.plants.data.model.Plant
import com.jassemdev.android.plants.data.model.PlantsApiModel

class FakeDataSource(var plants: MutableList<Plant> = mutableListOf()): PlantsDataSource {
    override suspend fun getPlants(): PlantsApiModel {
        return PlantsApiModel(plants.toList())
    }

}