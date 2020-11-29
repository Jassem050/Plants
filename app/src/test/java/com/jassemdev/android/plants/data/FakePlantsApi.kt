package com.jassemdev.android.plants.data

import com.jassemdev.android.plants.data.model.PlantItemApiModel
import com.jassemdev.android.plants.data.model.PlantsApiModel
import com.jassemdev.android.plants.home.fakePlantModel

class FakePlantsApi() : PlantsApi {
    override suspend fun getPlants(token: String): PlantsApiModel {
        return PlantsApiModel(
            data = listOf(fakePlantModel)
        )
    }

    override suspend fun getPlantsByPage(pageNumber: Long, token: String): PlantsApiModel {
        TODO("Not yet implemented")
    }

    override suspend fun getPlantById(id: Long, token: String): PlantItemApiModel {
        return PlantItemApiModel(data = fakePlantModel)
    }

}
