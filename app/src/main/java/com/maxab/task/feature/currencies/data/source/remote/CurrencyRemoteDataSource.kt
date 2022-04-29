package com.maxab.task.feature.currencies.data.source.remote

import com.maxab.task.core.network.adapter.NetworkResponse
import com.maxab.task.core.network.response.ErrorResponse
import com.maxab.task.feature.currencies.data.response.CurrenciesResponse
import retrofit2.http.QueryMap

interface CurrencyRemoteDataSource {
    suspend fun getLatestCurrencies(
        @QueryMap param: HashMap<String, String?>
    ): NetworkResponse<CurrenciesResponse, ErrorResponse>
}