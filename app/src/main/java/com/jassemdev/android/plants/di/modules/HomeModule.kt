package com.jassemdev.android.plants.di.modules

import androidx.lifecycle.ViewModel
import com.jassemdev.android.plants.di.viewmodel.ViewModelKey
import com.jassemdev.android.plants.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface HomeModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel
}