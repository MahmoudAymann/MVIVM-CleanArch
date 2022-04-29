package com.maxab.task.feature.currency_converter.ui

import com.maxab.task.core.android.BaseViewModel
import com.maxab.task.core.android.UiState

sealed class CurrencyConverterUiState : UiState {
    object Init : CurrencyConverterUiState()
}

class CurrencyConverterViewModel :
    BaseViewModel<CurrencyConverterUiState>(CurrencyConverterUiState.Init)