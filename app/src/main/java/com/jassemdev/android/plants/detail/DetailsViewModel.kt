package com.jassemdev.android.plants.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jassemdev.android.plants.data.PlantsRepository
import com.jassemdev.android.plants.data.model.Plant
import com.jassemdev.android.plants.data.model.PlantItemApiModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailsViewModel @Inject constructor(
    private val plantsRepository: PlantsRepository
) : ViewModel() {

    private var _data = MutableLiveData<Plant>()

    val data: LiveData<Plant>
        get() = _data


/*
    fun getPlantById(id: Long) {
        viewModelScope.launch {
            _data.value = plantsRepository.getPlantById(id).data
        }
    }
*/
}