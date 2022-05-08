package com.mayman.mvivm.feature.currencies.ui

import com.mayman.mvivm.core.arch.UiState
import com.mayman.mvivm.feature.currencies.data.entity.CurrencyItem


data class CurrencyUiState(
    val listOfCurrencies: List<CurrencyItem> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
) : UiState