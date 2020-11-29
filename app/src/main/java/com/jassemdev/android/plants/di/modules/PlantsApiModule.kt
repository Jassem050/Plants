package com.jassemdev.android.plants.di.modules

import com.jassemdev.android.plants.data.PlantsApi
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
object PlantsApiModule {


    @JvmStatic
    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }

    @JvmStatic
    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .build()
    }

    @JvmStatic
    @Provides
    @Singleton
    fun provideRetrofit(moshi: Moshi, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://trefle.io/api/v1/")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }


    @JvmStatic
    @Provides
    @Singleton
    fun providePlantsApi(retrofit: Retrofit): PlantsApi {
        return retrofit.create()
    }
}