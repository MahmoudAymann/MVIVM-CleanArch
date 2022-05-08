package com.mayman.mvivm.feature.currency_converter.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ConverterItem(
    val amount: Double, //displayed amount in UI
    val currency: String,
    val exchangeRate: Double
) : Parcelable