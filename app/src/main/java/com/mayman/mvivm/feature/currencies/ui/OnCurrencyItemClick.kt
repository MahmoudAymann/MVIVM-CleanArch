package com.mayman.mvivm.feature.currencies.ui

import com.mayman.mvivm.feature.currencies.data.entity.CurrencyItem

interface OnCurrencyItemClickListener {
    fun onClick(item: CurrencyItem)
}