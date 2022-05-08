package com.mayman.mvivm.feature.currencies.ui

import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.mayman.mvivm.R
import com.mayman.mvivm.core.android.BaseFragment
import com.mayman.mvivm.core.extensions.navigateSafe
import com.mayman.mvivm.core.extensions.observe
import com.mayman.mvivm.databinding.FragmentCurrencyBinding
import com.mayman.mvivm.feature.currencies.data.entity.CurrencyItem
import com.mayman.mvivm.feature.currency_converter.data.ConverterItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CurrencyFragment : BaseFragment<FragmentCurrencyBinding>(FragmentCurrencyBinding::inflate),
    OnCurrencyItemClickListener {
    private var state: Parcelable? = null
    private val viewModel by viewModels<CurrencyViewModel>()
    private val adapter by lazy { CurrencyAdapter(this) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleViewState()
        initUi()
        handleClickListeners()
    }

    override fun onPause() {
        super.onPause()
        state = binding.contentLayout.rvCurrencies.layoutManager?.onSaveInstanceState()
    }

    override fun onResume() {
        super.onResume()
        binding.contentLayout.rvCurrencies.layoutManager?.onRestoreInstanceState(state)
    }

    private fun handleClickListeners() {
        binding.switchCurrency.let {
            it.setOnClickListener { _ ->
                if (it.isChecked) {
                    it.text = getString(R.string.online)
                } else {
                    it.text = getString(R.string.offline)
                }
                viewModel.removeSavedState()
                viewModel.loadCurrencies(it.isChecked)
            }
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
            adapter.submitList(state.listOfCurrencies) {
                viewModel.setSavedStateValue(1)
            }
            if (!state.errorMessage.isNullOrBlank()) {
                Toast.makeText(requireContext(), state.errorMessage, Toast.LENGTH_SHORT).show()
            }
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