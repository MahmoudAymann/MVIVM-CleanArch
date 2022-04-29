package com.maxab.task.feature.currency_converter.ui

import com.maxab.task.core.android.BaseViewModel
import com.maxab.task.feature.currency_converter.data.ConverterParam
import com.maxab.task.feature.currency_converter.domain.CurrencyConverterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CurrencyConverterViewModel @Inject constructor(private val currencyConverterUseCase: CurrencyConverterUseCase) :
    BaseViewModel<CurrencyConverterUiState>(CurrencyConverterUiState(0.0)) {

    fun convert(param: ConverterParam) {
        val value = currencyConverterUseCase.execute(param)
        emit(currentUiState.copy(amount = value))
    }

}