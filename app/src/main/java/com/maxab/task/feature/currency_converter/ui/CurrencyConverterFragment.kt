package com.maxab.task.feature.currency_converter.ui

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.maxab.task.core.android.BaseFragment
import com.maxab.task.core.extensions.observe
import com.maxab.task.core.extensions.showKeyboard
import com.maxab.task.core.extensions.toSafeDouble
import com.maxab.task.databinding.FragmentCurrencyConverterBinding

class CurrencyConverterFragment :
    BaseFragment<FragmentCurrencyConverterBinding>(FragmentCurrencyConverterBinding::inflate) {

    private val viewModel: CurrencyConverterViewModel by viewModels()
    private val args by navArgs<CurrencyConverterFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleTextInputs()
    }

    private fun handleTextInputs() {
        binding.etAmountInput.let { et ->
            et.requestFocus()
            et.doAfterTextChanged {
                //For test only
                it?.toString()?.toSafeDouble()?.let { input ->
                    binding.tvToAmount.text = (input * 0.60).toString()
                }
            }
        }
    }

    private fun handleViewState() {
        observe(viewModel.uiState) { state ->
            when (state) {
                CurrencyConverterUiState.Init -> initUI()
            }
        }
    }

    private fun initUI() {
        with(binding) {
//            args.fromCurrency.let { from ->
//                etAmountInput.setText(from.amount.toString())
//                tvFromCurrency.text = from.currency
//            }
//            args.toCurrency.let {
//                tvToAmount.text = it.amount.toString()
//                tvToCurrency.text = it.currency
//            }
        }
        showKeyboard()
        handleViewState()
    }


}