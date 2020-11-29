package com.jassemdev.android.plants.home

import com.jassemdev.android.plants.data.PlantsApi
import com.jassemdev.android.plants.data.PlantsDataSource
import com.jassemdev.android.plants.data.model.Plant
import com.jassemdev.android.plants.data.model.PlantsApiModel

//class HomeRepository(private val plantsApi: PlantsApi): PlantsDataSource {
//
//    // Basic type of Caching
//    private val cachedPlantsData = mutableListOf<Plant>()
//
//    override suspend fun getPlants(): PlantsApiModel {
//        if (cachedPlantsData.isEmpty()) {
//            cachedPlantsData.addAll(plantsApi.getPlants("vgfQYy5rQjOc1BznX3d5_lHwdEZr4qiGeFVYM1WpXeA").data)
//        }
//        return PlantsApiModel(cachedPlantsData)
//    }
//
//    override suspend fun getPlantsByPage(pageNumber: Int, token: String): PlantsApiModel {
//        TODO("Not yet implemented")
//    }
//
//}