package com.maxab.task.feature.currencies.data.source.remote

import com.maxab.task.core.network.adapter.NetworkResponse
import com.maxab.task.core.network.response.ErrorResponse
import com.maxab.task.feature.currencies.data.response.CurrenciesResponse
import com.maxab.task.main.service.HomeApiService
import javax.inject.Inject

class CurrencyRemoteDataSourceImpl @Inject constructor(
    private val apiService: HomeApiService
) : CurrencyRemoteDataSource {
    override suspend fun getLatestCurrencies(param: HashMap<String, String?>): NetworkResponse<CurrenciesResponse, ErrorResponse> =
        apiService.getLatestCurrencies(param)

}