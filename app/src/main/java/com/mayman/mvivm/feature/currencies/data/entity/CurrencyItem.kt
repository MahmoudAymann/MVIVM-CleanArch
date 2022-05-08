package com.mayman.mvivm.feature.currencies.data.entity

data class CurrencyItem(
    val currency: String,
    val exchangeRate: Double
) {
    override fun toString(): String {
        return currency
    }
}