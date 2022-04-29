package com.maxab.task.feature.currency_converter.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ConverterItem(
    val amount: Double,
    val currency: String,
    val exchangeRate: Double
) : Parcelable