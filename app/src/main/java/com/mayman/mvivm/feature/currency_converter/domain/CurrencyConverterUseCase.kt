package com.mayman.mvivm.feature.currency_converter.domain

import com.mayman.mvivm.core.arch.BaseUseCase
import com.mayman.mvivm.feature.currency_converter.data.ConverterParam
import javax.inject.Inject

class CurrencyConverterUseCase @Inject constructor() : BaseUseCase<ConverterParam, Double>() {
    override suspend fun execute(input: ConverterParam): Double =
        (input.amount * input.exchangeRate)
}