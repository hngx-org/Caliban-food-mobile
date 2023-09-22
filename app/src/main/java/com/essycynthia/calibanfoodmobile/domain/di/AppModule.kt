package com.essycynthia.calibanfoodmobile.domain.di

import com.essycynthia.calibanfoodmobile.data.remote.FoodApi
import com.essycynthia.calibanfoodmobile.domain.repository.FreeLunchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRepository( api: FoodApi) : FreeLunchRepository{
        return FreeLunchRepository(api)
    }
}