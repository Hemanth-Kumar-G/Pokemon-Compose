package com.hemanthddev.pokemon.di

import com.hemanthddev.pokemon.data.remote.ApiService
import com.hemanthddev.pokemon.repository.Repository
import com.hemanthddev.pokemon.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun providePokemonRepository(
        api: ApiService
    ) = Repository(api)

    @Singleton
    @Provides
    fun provideApi(): ApiService =
        Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiService::class.java)
}