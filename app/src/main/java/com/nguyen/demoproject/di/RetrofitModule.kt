package com.nguyen.demoproject.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.nguyen.demoproject.api.service.HiringService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val baseURL = "https://fetch-hiring.s3.amazonaws.com"

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create(gson))
    }


    @Singleton
    @Provides
    fun provideHiringService(retrofit: Retrofit.Builder): HiringService {
        return retrofit
            .build()
            .create(HiringService::class.java)
    }
}