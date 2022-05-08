package com.mayman.mvivm.feature.currency_converter.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.mayman.mvivm.core.android.BaseFragment
import com.mayman.mvivm.core.extensions.observe
import com.mayman.mvivm.core.extensions.showKeyboard
import com.mayman.mvivm.databinding.FragmentCurrencyConverterBinding
import com.mayman.mvivm.feature.currency_converter.data.ConverterParam
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CurrencyConverterFragment :
    BaseFragment<FragmentCurrencyConverterBinding>(FragmentCurrencyConverterBinding::inflate) {

    private val viewModel: CurrencyConverterViewModel by viewModels()
    private val args by navArgs<CurrencyConverterFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleViewState()
        initUI()
        handleTextInputs()
    }

    private fun handleTextInputs() {
        binding.etAmountInput.let { et ->
            et.requestFocus()
            et.doAfterTextChanged {
                it?.toString()?.toSafeDouble()?.let { input ->
                    viewModel.convert(
                        ConverterParam(
                            amount = input,
                            exchangeRate = args.toCurrency.exchangeRate
                        )
                    )
                }
            }
        }
    }

    private fun handleViewState() {
        observe(viewModel.uiState) { state ->
            binding.tvToAmount.text = state.amount.toString()
        }
    }

    private fun initUI() {
        with(binding) {
            args.fromCurrency.let { from ->
                etAmountInput.setText(from.amount.toString())
                tvFromCurrency.text = from.currency
            }
            args.toCurrency.let {
                tvToAmount.text = it.amount.toString()
                tvToCurrency.text = it.currency
            }
        }
        showKeyboard()
        viewModel.convert(
            ConverterParam(
                amount = args.fromCurrency.amount,
                exchangeRate = args.toCurrency.exchangeRate
            )
        )
    }


}