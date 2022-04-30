package com.maxab.task.feature.currencies.domain.usecase

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.maxab.task.core.arch.BaseUseCase
import com.maxab.task.core.extensions.toHashMapParams
import com.maxab.task.core.extensions.toSafeDouble
import com.maxab.task.core.network.NetworkResource
import com.maxab.task.core.network.adapter.NetworkResponse
import com.maxab.task.feature.currencies.data.entity.CurrencyItem
import com.maxab.task.feature.currencies.data.entity.GetCurrenciesParam
import com.maxab.task.feature.currencies.domain.repo.CurrencyRepository
import javax.inject.Inject

class GetCurrenciesUseCase @Inject constructor(
    private val currencyRepository: CurrencyRepository
) : BaseUseCase<GetCurrenciesParam, NetworkResource<List<CurrencyItem>>>() {

    override suspend fun execute(input: GetCurrenciesParam): NetworkResource<List<CurrencyItem>> {
        return when (val response =
            currencyRepository.getLatestCurrencies(input.toHashMapParams()!!)) {
            is NetworkResponse.NetworkError -> NetworkResource.failure("Network Error")
            is NetworkResponse.ServerError -> NetworkResource.failure("Server Error")
            is NetworkResponse.Success -> {
                if (response.body.success == true) {
                    NetworkResource.success(mapper(response.body.rates))
                } else {
                    NetworkResource.failure(response.body.error?.info ?: "Unknown Error")
                }
            }
            is NetworkResponse.UnknownError -> NetworkResource.failure("Unknown Error")
        }
    }

    private fun mapper(rates: Any?): List<CurrencyItem> {
        val jsonObject: JsonObject = Gson().toJsonTree(rates).asJsonObject
        val resList = mutableListOf<CurrencyItem>()
        jsonObject.entrySet().forEach {
            resList.add(
                CurrencyItem(
                    currency = it.key,
                    exchangeRate = it.value.asString.toSafeDouble()
                )
            )
        }
        return resList
    }

}