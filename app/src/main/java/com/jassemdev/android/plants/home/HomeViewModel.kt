package com.jassemdev.android.plants.home

import android.util.Log
import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.jassemdev.android.plants.data.PlantsRepository
import com.jassemdev.android.plants.data.model.Plant
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.concurrent.Flow
import javax.inject.Inject

private const val TAG = "HomeViewModel"

@ExperimentalCoroutinesApi
class HomeViewModel @Inject constructor(
    private val plantsRepository: PlantsRepository
) : ViewModel() {

    private var _data = MutableStateFlow<PagingData<Plant>>(PagingData.empty())

    val data: StateFlow<PagingData<Plant>>
        get() = _data

    init {
        viewModelScope.launch {
            getPlantsData()
        }
    }

    suspend fun getPlantsData() {
        val plantsFlow = plantsRepository.getPlantsByPage().cachedIn(viewModelScope)
        plantsFlow.collect {
            _data.value = it
        }
    }
}