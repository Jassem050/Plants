package com.jassemdev.android.plants.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jassemdev.android.plants.data.PlantsRepository

class HomeViewModelFactory(private val plantsRepository: PlantsRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(plantsRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}