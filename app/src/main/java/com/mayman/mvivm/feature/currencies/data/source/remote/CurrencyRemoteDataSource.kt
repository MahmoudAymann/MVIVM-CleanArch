package com.mayman.mvivm.feature.currencies.data.source.remote

import com.mayman.mvivm.core.network.adapter.NetworkResponse
import com.mayman.mvivm.core.network.response.ErrorResponse
import com.mayman.mvivm.feature.currencies.data.response.CurrenciesResponse
import retrofit2.http.QueryMap

interface CurrencyRemoteDataSource {
    suspend fun getLatestCurrencies(
        @QueryMap param: HashMap<String, String?>
    ): NetworkResponse<CurrenciesResponse, ErrorResponse>
}