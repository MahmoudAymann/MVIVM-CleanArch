package com.maxab.task.feature.currencies.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.maxab.task.core.android.BaseListAdapter
import com.maxab.task.core.android.BaseViewHolder
import com.maxab.task.databinding.ItemCurrencyViewBinding
import com.maxab.task.feature.currencies.data.CurrencyItem

class CurrencyAdapter(private val currencyItemClickListener: OnCurrencyItemClickListener) :
    BaseListAdapter<ItemCurrencyViewBinding, CurrencyItem>() {

    override fun createBinding(parent: ViewGroup, viewType: Int): ItemCurrencyViewBinding =
        ItemCurrencyViewBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

    override fun getViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<ItemCurrencyViewBinding> {
        return super.getViewHolder(parent, viewType).apply {
            itemView.setOnClickListener {
                currencyItemClickListener.onClick(getItem(adapterPosition))
            }
        }
    }

    override fun bind(binding: ItemCurrencyViewBinding, position: Int) {
        binding.tvCurrency.text = getItem(position).currency
        binding.tvExchangeRate.text = getItem(position).exchangeRate.toString()
    }
}