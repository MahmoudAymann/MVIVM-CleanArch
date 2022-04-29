package com.maxab.task.feature.currencies.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.maxab.task.R
import com.maxab.task.core.android.BaseFragment
import com.maxab.task.core.extensions.navigateSafe
import com.maxab.task.core.extensions.observe
import com.maxab.task.core.extensions.setup
import com.maxab.task.core.extensions.show
import com.maxab.task.databinding.FragmentCurrencyBinding
import com.maxab.task.feature.currencies.data.CurrencyItem
import com.maxab.task.feature.currency_converter.data.ConverterItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CurrencyFragment : BaseFragment<FragmentCurrencyBinding>(FragmentCurrencyBinding::inflate),
    OnCurrencyItemClickListener {

    private val viewModel by viewModels<CurrencyViewModel>()
    private val adapter by lazy { CurrencyAdapter(this) }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleViewState()
        initUi()
        handleClickListeners()
        viewModel.loadCurrencies(false)
    }

    private fun handleClickListeners() {
        binding.switchCurrency.setOnCheckedChangeListener { button, checked ->
            if (checked) {
                button.text = getString(R.string.online)
            } else {
                button.text = getString(R.string.offline)
            }
            viewModel.loadCurrencies(checked)
        }
    }

    private fun initUi() {
        binding.contentLayout.rvCurrencies.setup(
            adapter = adapter,
            showDivider = true
        )
    }

    private fun handleViewState() {
        observe(viewModel.uiState) { state ->
            binding.contentLayout.progressBar.show(state.isLoading)
            adapter.submitList(state.listOfCurrencies)
        }
    }

    override fun onClick(item: CurrencyItem) {
        navigateSafe(
            CurrencyFragmentDirections.actionCurrencyFragmentToCurrencyConverterFragment(
                fromCurrency = ConverterItem(
                    amount = 1.0,
                    currency = getString(R.string.eur),
                    exchangeRate = 1.0
                ), toCurrency = ConverterItem(
                    amount = 0.0,
                    currency = item.currency,
                    exchangeRate = item.exchangeRate
                )
            )
        )//end navigateSafe
    }
}