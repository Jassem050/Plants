package com.jassemdev.android.plants.data

import androidx.paging.PagingSource
import com.jassemdev.android.plants.data.model.Plant
import com.jassemdev.android.plants.data.source.remote.PlantsRemoteDataSource
import okio.IOException
import retrofit2.HttpException

private const val PLANTS_STARTING_INDEX = 1


class PlantsPagingSource (
    private val remoteDataSource: PlantsDataSource,
    private val token: String,
) : PagingSource<Int, Plant>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Plant> {
        val position = params.key ?: PLANTS_STARTING_INDEX

        return try {
            val response = remoteDataSource.getPlantsByPage(position, token)
            val data = response.data
            LoadResult.Page(
                data = data,
                prevKey = if (position == PLANTS_STARTING_INDEX) null else position - 1,
                nextKey = if (data.isEmpty()) null else position + 1
            )

        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }
}