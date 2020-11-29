package com.jassemdev.android.plants.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.jassemdev.android.plants.MainCoroutineRule
import com.jassemdev.android.plants.data.FakePlantsApi
import com.jassemdev.android.plants.getValueForTest
import com.jassemdev.android.plants.home.fakePlantModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class DetailsViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: DetailsViewModel
//    private lateinit var repository: DetailsRepository
//
//    @Before
//    fun setUp() {
//        repository = DetailsRepository(FakePlantsApi())
//        viewModel = DetailsViewModel(repository)
//    }
//
//    @Test
//    fun getPlantsById_returnsPlantData() {
//        viewModel.getPlantById(1L)
//
//        val result = viewModel.data.getValueForTest()
//        val expected = fakePlantModel
//
//        assertThat(result).isEqualTo(expected)
//    }
}