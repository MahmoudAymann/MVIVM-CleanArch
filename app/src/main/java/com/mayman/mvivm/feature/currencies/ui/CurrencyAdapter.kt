package com.mayman.mvivm.feature.currencies.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mayman.mvivm.core.android.BaseListAdapter
import com.mayman.mvivm.core.android.BaseViewHolder
import com.mayman.mvivm.databinding.ItemCurrencyViewBinding
import com.mayman.mvivm.feature.currencies.data.entity.CurrencyItem

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