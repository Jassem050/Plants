package com.jassemdev.android.plants.di.modules

import com.jassemdev.android.plants.data.PlantsApi
import com.jassemdev.android.plants.data.PlantsDataSource
import com.jassemdev.android.plants.data.source.local.PlantsLocalDataSource
import com.jassemdev.android.plants.data.source.remote.PlantsRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
object PlantsDataSourceModule {

    @JvmStatic
    @Provides
    @Named("remote")
    fun bindPlantsRemoteDataSource(plantsApi: PlantsApi): PlantsDataSource {
        return PlantsRemoteDataSource(plantsApi)
    }

    @JvmStatic
    @Provides
    @Named("local")
    fun bindPlantsLocalDataSource(): PlantsDataSource {
        return PlantsLocalDataSource()
    }
}