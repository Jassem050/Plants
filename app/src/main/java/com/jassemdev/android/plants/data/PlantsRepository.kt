package com.jassemdev.android.plants.data

import androidx.paging.PagingData
import com.jassemdev.android.plants.data.model.Plant
import com.jassemdev.android.plants.data.model.PlantsApiModel
import kotlinx.coroutines.flow.Flow

interface PlantsRepository {
    suspend fun getPlants(): PlantsApiModel
    suspend fun getPlantsByPage(): Flow<PagingData<Plant>>
}