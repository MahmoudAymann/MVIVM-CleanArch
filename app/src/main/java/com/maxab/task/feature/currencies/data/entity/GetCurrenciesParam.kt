package com.maxab.task.feature.currencies.data.entity

import com.maxab.task.core.arch.HashMapParams

data class GetCurrenciesParam(
    val accessKey: String,
    val baseCurrency: String,
    val symbols: String
) : HashMapParams {
    override fun dataClass() = this
}
