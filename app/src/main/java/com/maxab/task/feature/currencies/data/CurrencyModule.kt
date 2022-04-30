package com.maxab.task.feature.currencies.data

import com.maxab.task.feature.currencies.data.repo.CurrencyRepositoryImpl
import com.maxab.task.feature.currencies.data.source.remote.CurrencyRemoteDataSource
import com.maxab.task.feature.currencies.data.source.remote.CurrencyRemoteDataSourceImpl
import com.maxab.task.feature.currencies.domain.repo.CurrencyRepository
import com.maxab.task.main.service.HomeApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
class CurrencyModule {

    @Provides
    fun provideCurrencyRemoteDataSource(apiService: HomeApiService): CurrencyRemoteDataSource =
        CurrencyRemoteDataSourceImpl(apiService)

    @Provides
    fun provideCurrencyRepository(remoteDataSource: CurrencyRemoteDataSource): CurrencyRepository =
        CurrencyRepositoryImpl(remoteDataSource)
}