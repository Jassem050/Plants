package com.jassemdev.android.plants.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.jassemdev.android.plants.MainCoroutineRule
import com.jassemdev.android.plants.data.*
import com.jassemdev.android.plants.data.model.Plant
import com.jassemdev.android.plants.data.model.PlantItemApiModel
import com.jassemdev.android.plants.data.model.PlantsApiModel
import com.jassemdev.android.plants.data.source.local.PlantsLocalDataSource
import com.jassemdev.android.plants.data.source.remote.PlantsRemoteDataSource
import com.jassemdev.android.plants.getValueForTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@ExperimentalCoroutinesApi
class HomeViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: HomeViewModel
    private lateinit var plantsRepository: PlantsRepository
    private lateinit var plantsRemoteDataSource: PlantsDataSource
    private lateinit var plantsLocalDataSource: PlantsDataSource

    @Before
    fun setUp() {
        plantsRemoteDataSource = PlantsRemoteDataSource(FakePlantsApi())
        plantsLocalDataSource = PlantsLocalDataSource()
        plantsRepository = DefaultPlantsRepository(plantsRemoteDataSource, plantsLocalDataSource)
        viewModel = HomeViewModel(plantsRepository)
    }

    @Test
    fun getPlants_retrieveListOfPlants() = runBlockingTest {
        viewModel.getPlantsData()

        val result = viewModel.data.getValueForTest()
        val expected = listOf(fakePlantModel)

        assertThat(result.size).isEqualTo(1)
        assertThat(result).isEqualTo(expected)
    }

}


val fakePlantModel = Plant(
        id = 1L,
        author = "Brad",
        bibliography = "J.k",
        name = "Evergreen Oak",
        imageUrl = "pimage.url",
        scientificName = "Species",
        year = "2000",
        slug = "slug",
        rank = "species",
        family = "Fagaceae",
        familyName = "Beach Family",
        genus = "Quercus"
)



