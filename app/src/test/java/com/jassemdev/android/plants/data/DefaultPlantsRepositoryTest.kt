package com.jassemdev.android.plants.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.jassemdev.android.plants.data.model.PlantsApiModel
import com.jassemdev.android.plants.data.source.FakeDataSource
import com.jassemdev.android.plants.home.fakePlantModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class DefaultPlantsRepositoryTest {

    private val plantList = mutableListOf(fakePlantModel)

    private lateinit var plantsRepository: DefaultPlantsRepository
    private lateinit var plantsRemoteDataSource: FakeDataSource
    private lateinit var plantsLocalDataSource: FakeDataSource

    @Before
    fun setUp() {
        plantsLocalDataSource = FakeDataSource(plantList)
        plantsRemoteDataSource = FakeDataSource(plantList)
        plantsRepository = DefaultPlantsRepository(plantsRemoteDataSource, plantsLocalDataSource)
    }

    @Test
    fun getPlants_requestAllPlantsInfoFromRemoteDataSource() = runBlockingTest {
        val result = plantsRepository.getPlants()
        val expected = PlantsApiModel(plantList)

       assertThat(result).isEqualTo(expected)
        assertThat(result.data.size).isEqualTo(1)
    }
}