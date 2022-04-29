package com.maxab.task.feature.currencies.data.repo

import com.maxab.task.core.network.adapter.NetworkResponse
import com.maxab.task.core.network.response.ErrorResponse
import com.maxab.task.feature.currencies.data.response.CurrenciesResponse
import com.maxab.task.feature.currencies.data.source.remote.CurrencyRemoteDataSource
import com.maxab.task.feature.currencies.domain.repo.CurrencyRepository
import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor(private val currencyRemoteDataSource: CurrencyRemoteDataSource) :
    CurrencyRepository {
    override suspend fun getLatestCurrencies(param: HashMap<String, String?>): NetworkResponse<CurrenciesResponse, ErrorResponse> =
        currencyRemoteDataSource.getLatestCurrencies(param)
}