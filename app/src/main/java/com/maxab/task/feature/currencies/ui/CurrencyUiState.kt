package com.maxab.task.feature.currencies.ui

import com.maxab.task.core.arch.UiState
import com.maxab.task.feature.currencies.data.entity.CurrencyItem


data class CurrencyUiState(
    val listOfCurrencies: List<CurrencyItem> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
) : UiState