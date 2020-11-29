package com.jassemdev.android.plants.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jassemdev.android.plants.data.PlantsRepository


class DetailsViewModelFactory(
    private val plantsRepository: PlantsRepository) :  ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DetailsViewModel(plantsRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}