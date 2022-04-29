package com.maxab.task.main.service

import com.maxab.task.core.network.adapter.NetworkResponse
import com.maxab.task.core.network.response.ErrorResponse
import com.maxab.task.feature.currencies.data.response.CurrenciesResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface HomeApiService {

    companion object {
        const val LATEST_CURRENCIES = "latest"
    }

    @GET(LATEST_CURRENCIES)
    suspend fun getLatestCurrencies(
        @QueryMap param: HashMap<String, String?>
    ): NetworkResponse<CurrenciesResponse, ErrorResponse>

}