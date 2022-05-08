package com.mayman.mvivm.feature.currencies.data.entity

import com.mayman.mvivm.core.arch.HashMapParams
import com.mayman.mvivm.core.extensions.removeWhitespaces

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
