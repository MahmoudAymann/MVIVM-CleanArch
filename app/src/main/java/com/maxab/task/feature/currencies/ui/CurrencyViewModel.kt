package com.maxab.task.feature.currencies.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.maxab.task.core.android.BaseViewModel
import com.maxab.task.core.network.NetworkHandler
import com.maxab.task.core.network.NetworkResource
import com.maxab.task.feature.currencies.data.entity.CurrencyItem
import com.maxab.task.feature.currencies.data.entity.GetCurrenciesParam
import com.maxab.task.feature.currencies.domain.usecase.GetCurrenciesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class CurrencyViewModel @Inject constructor(
    private val getCurrenciesUseCase: GetCurrenciesUseCase,
    private val networkHandler: NetworkHandler,
    private val savedStateHandle: SavedStateHandle
) : BaseViewModel<CurrencyUiState>(CurrencyUiState()) {

    private val dummyList: List<CurrencyItem> =
        listOf(
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
    private val params by lazy { GetCurrenciesParam.defaults(dummyList) }

    fun setSavedStateValue(pos: Int) {
        savedStateHandle["pos"] = pos
    }

    init {
        loadCurrencies(false)
    }

    fun removeSavedState() = savedStateHandle.remove<Int>("pos")

    //get updated exchange rates from fixer.io or from Cache
    fun loadCurrencies(online: Boolean) {
        Timber.e(savedStateHandle.keys().size.toString())
        if (savedStateHandle.keys().isNotEmpty())
            return
        if (online) {
            checkForNetworkConnection()
            emit(currentUiState.copy(isLoading = true))
            viewModelScope.launch(Dispatchers.IO + handler) {
                val res = getCurrenciesUseCase.execute(params)
                withContext(Dispatchers.Main) {   //switch to main thread
                    when (res) {
                        is NetworkResource.Failure -> emit(
                            currentUiState.copy(
                                errorMessage = res.message,
                                isLoading = false
                            )
                        )
                        is NetworkResource.Success -> emit(
                            currentUiState.copy(
                                listOfCurrencies = res.data,
                                isLoading = false
                            )
                        )
                    }
                }
            }
        } else { //You are offline
            emit(
                currentUiState.copy(
                    listOfCurrencies = dummyList
                )
            )
        }
    }

    private fun checkForNetworkConnection() {
        if (!networkHandler.isNetworkAvailable()) {
            emit(
                currentUiState.copy(
                    isLoading = false,
                    listOfCurrencies = dummyList,
                    errorMessage = "no internet connection"
                )
            )
            return
        }
    }


    private val handler = CoroutineExceptionHandler { _, exception ->
        Timber.e("CoroutineExceptionHandler got $exception")
        emit(currentUiState.copy(isLoading = false, errorMessage = exception.message))
    }

}