package com.mayman.mvivm.feature.currencies.data

import com.mayman.mvivm.feature.currencies.data.repo.CurrencyRepositoryImpl
import com.mayman.mvivm.feature.currencies.data.source.remote.CurrencyRemoteDataSource
import com.mayman.mvivm.feature.currencies.data.source.remote.CurrencyRemoteDataSourceImpl
import com.mayman.mvivm.feature.currencies.domain.repo.CurrencyRepository
import com.mayman.mvivm.main.service.HomeApiService
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