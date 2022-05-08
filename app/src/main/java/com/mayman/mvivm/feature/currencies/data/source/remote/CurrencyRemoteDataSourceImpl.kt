package com.mayman.mvivm.feature.currencies.data.source.remote

import com.mayman.mvivm.core.network.adapter.NetworkResponse
import com.mayman.mvivm.core.network.response.ErrorResponse
import com.mayman.mvivm.feature.currencies.data.response.CurrenciesResponse
import com.mayman.mvivm.main.service.HomeApiService
import javax.inject.Inject

class CurrencyRemoteDataSourceImpl @Inject constructor(
    private val apiService: HomeApiService
) : CurrencyRemoteDataSource {
    override suspend fun getLatestCurrencies(param: HashMap<String, String?>): NetworkResponse<CurrenciesResponse, ErrorResponse> =
        apiService.getLatestCurrencies(param)

}