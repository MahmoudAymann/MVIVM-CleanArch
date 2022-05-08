package com.mayman.mvivm.feature.currency_converter.ui

import androidx.lifecycle.viewModelScope
import com.mayman.mvivm.core.android.BaseViewModel
import com.mayman.mvivm.feature.currency_converter.data.ConverterParam
import com.mayman.mvivm.feature.currency_converter.domain.CurrencyConverterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrencyConverterViewModel @Inject constructor(private val currencyConverterUseCase: CurrencyConverterUseCase) :
    BaseViewModel<CurrencyConverterUiState>(CurrencyConverterUiState(0.0)) {

    fun convert(param: ConverterParam) {
        viewModelScope.launch {
            val value = currencyConverterUseCase.execute(param)
            emit(currentUiState.copy(amount = value))
        }
    }

}