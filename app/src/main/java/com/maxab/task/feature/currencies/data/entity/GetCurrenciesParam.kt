package com.maxab.task.feature.currencies.data.entity

import com.maxab.task.core.arch.HashMapParams
import com.maxab.task.core.extensions.removeWhitespaces

data class GetCurrenciesParam(
    val baseCurrency: String,
    val symbols: String
) : HashMapParams {
    override fun dataClass() = this

    companion object {
        fun defaults(listOfCurrencies: List<CurrencyItem>): GetCurrenciesParam = GetCurrenciesParam(
            baseCurrency = "EUR",
            symbols = listOfCurrencies.toString().removeSurrounding("[", "]").removeWhitespaces()
        )
    }
}
