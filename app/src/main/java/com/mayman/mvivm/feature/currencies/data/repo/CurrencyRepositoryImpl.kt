package com.mayman.mvivm.feature.currencies.data.repo

import com.mayman.mvivm.core.network.adapter.NetworkResponse
import com.mayman.mvivm.core.network.response.ErrorResponse
import com.mayman.mvivm.feature.currencies.data.response.CurrenciesResponse
import com.mayman.mvivm.feature.currencies.data.source.remote.CurrencyRemoteDataSource
import com.mayman.mvivm.feature.currencies.domain.repo.CurrencyRepository
import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor(private val currencyRemoteDataSource: CurrencyRemoteDataSource) :
    CurrencyRepository {
    override suspend fun getLatestCurrencies(param: HashMap<String, String?>): NetworkResponse<CurrenciesResponse, ErrorResponse> =
        currencyRemoteDataSource.getLatestCurrencies(param)
}