package com.maxab.task.feature.currency_converter.domain

import com.maxab.task.core.arch.BaseUseCase
import com.maxab.task.feature.currency_converter.data.ConverterParam
import javax.inject.Inject

class CurrencyConverterUseCase @Inject constructor() : BaseUseCase<ConverterParam, Double>() {
    override suspend fun execute(input: ConverterParam): Double =
        (input.amount * input.exchangeRate)
}