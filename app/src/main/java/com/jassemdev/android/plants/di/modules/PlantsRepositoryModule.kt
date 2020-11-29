package com.jassemdev.android.plants.di.modules

import com.jassemdev.android.plants.data.DefaultPlantsRepository
import com.jassemdev.android.plants.data.PlantsRepository
import dagger.Binds
import dagger.Module

@Module
interface PlantsRepositoryModule {

    @Binds
    fun bindDefaultPlantsRepository(
        defaultPlantsRepository: DefaultPlantsRepository): PlantsRepository
}