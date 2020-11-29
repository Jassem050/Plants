package com.jassemdev.android.plants.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.jassemdev.android.plants.data.model.Plant
import com.jassemdev.android.plants.data.model.PlantsApiModel
import com.jassemdev.android.plants.data.source.local.PlantsLocalDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class DefaultPlantsRepository @Inject constructor(
        @Named("remote") private val plantsRemoteDataSource: PlantsDataSource,
        @Named("local") private val plantsLocalDataSource: PlantsDataSource
): PlantsRepository {

    // Basic type of Caching
    private val cachedPlantsData = mutableListOf<Plant>()

    override suspend fun getPlants(): PlantsApiModel {
        if (cachedPlantsData.isEmpty()) {
            cachedPlantsData.addAll(plantsRemoteDataSource.getPlants().data)
        }
        return PlantsApiModel(plantsRemoteDataSource.getPlants().data)
    }

    override suspend fun getPlantsByPage(): Flow<PagingData<Plant>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { PlantsPagingSource(plantsRemoteDataSource, PlantsToken.token)}
        ).flow
    }
    companion object {
        private const val NETWORK_PAGE_SIZE = 20
    }
}

