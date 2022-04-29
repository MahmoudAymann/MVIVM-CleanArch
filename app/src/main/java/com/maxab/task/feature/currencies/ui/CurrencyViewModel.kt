package com.maxab.task.feature.currencies.ui

import androidx.lifecycle.viewModelScope
import com.maxab.task.core.android.BaseViewModel
import com.maxab.task.core.arch.UiState
import com.maxab.task.feature.currencies.data.entity.CurrencyItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

data class CurrencyUiState(
    val listOfCurrencies: List<CurrencyItem>,
    val isLoading: Boolean
) : UiState

@HiltViewModel
class CurrencyViewModel @Inject constructor() :
    BaseViewModel<CurrencyUiState>(
        CurrencyUiState(
            listOfCurrencies = emptyList(),
            isLoading = false
        )
    ) {

    //get updated exchange rates from fixer.io or from Cache
    fun loadCurrencies(online: Boolean) {
        if (online) {
            emit(currentUiState.copy(isLoading = true))
            viewModelScope.launch {
                delay(2000)
                emit(currentUiState.copy(listOfCurrencies = emptyList(), isLoading = false))
            }
        } else {
            emit(
                currentUiState.copy(
                    listOfCurrencies = getDummyList()
                )
            )
        }
    }

    private fun getDummyList(): List<CurrencyItem> = listOf(
        CurrencyItem(
            currency = "USD",
            exchangeRate = 0.175
        ),
        CurrencyItem(
            currency = "EGP",
            exchangeRate = 0.114
        ),
        CurrencyItem(
            currency = "BHD",
            exchangeRate = 0.133
        ),
        CurrencyItem(
            currency = "GBP",
            exchangeRate = 0.2
        ),
        CurrencyItem(
            currency = "INR",
            exchangeRate = 60.90
        ),
        CurrencyItem(
            currency = "AUD",
            exchangeRate = 2.5
        ),
        CurrencyItem(
            currency = "KWD",
            exchangeRate = .23
        ),
        CurrencyItem(
            currency = "RUB",
            exchangeRate = 0.2
        ),
        CurrencyItem(
            currency = "SAR",
            exchangeRate = 0.2
        ),
        CurrencyItem(
            currency = "AED",
            exchangeRate = 0.2
        )
    )

}