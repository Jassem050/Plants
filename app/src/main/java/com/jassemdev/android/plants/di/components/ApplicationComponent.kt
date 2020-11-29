package com.jassemdev.android.plants.di.components

import android.content.Context
import com.jassemdev.android.plants.di.modules.HomeModule
import com.jassemdev.android.plants.di.modules.PlantsApiModule
import com.jassemdev.android.plants.di.modules.PlantsDataSourceModule
import com.jassemdev.android.plants.di.modules.PlantsRepositoryModule
import com.jassemdev.android.plants.home.HomeFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [PlantsDataSourceModule::class, PlantsRepositoryModule::class, HomeModule::class,
                PlantsApiModule::class])
interface ApplicationComponent {

    fun inject(homeFragment: HomeFragment)

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance context: Context): ApplicationComponent
    }


}