package com.maxab.task.feature.currencies.ui

import com.maxab.task.feature.currencies.data.entity.CurrencyItem

interface OnCurrencyItemClickListener {
    fun onClick(item: CurrencyItem)
}