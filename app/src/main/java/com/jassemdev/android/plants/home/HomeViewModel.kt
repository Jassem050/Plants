package com.jassemdev.android.plants.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jassemdev.android.plants.data.PlantsRepository
import com.jassemdev.android.plants.data.model.Plant
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "HomeViewModel"

class HomeViewModel @Inject constructor(
    private val plantsRepository: PlantsRepository
) : ViewModel() {

    private var _data = MutableLiveData<List<Plant>>()

    val data: LiveData<List<Plant>>
        get() = _data

    init {
        viewModelScope.launch {
            getPlantsData()
        }
    }

    suspend fun getPlantsData() {
        _data.value = plantsRepository.getPlants().data
    }
}