package com.jassemdev.android.plants.data.source.remote

import com.jassemdev.android.plants.data.PlantsApi
import com.jassemdev.android.plants.data.PlantsDataSource
import com.jassemdev.android.plants.data.model.PlantsApiModel

class PlantsRemoteDataSource(private val plantsApi: PlantsApi): PlantsDataSource {
    override suspend fun getPlants(): PlantsApiModel {
        return plantsApi.getPlants("vgfQYy5rQjOc1BznX3d5_lHwdEZr4qiGeFVYM1WpXeA")
    }

    override suspend fun getPlantsByPage(pageNumber: Int, token: String): PlantsApiModel {
        return plantsApi.getPlantsByPage(pageNumber, token)
    }

}