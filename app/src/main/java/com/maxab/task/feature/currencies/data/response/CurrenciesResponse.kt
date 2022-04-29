package com.maxab.task.feature.currencies.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.maxab.task.core.network.response.BaseResponse
import kotlinx.parcelize.Parcelize

@Parcelize
data class CurrenciesResponse(
	@field:SerializedName("date")
	val date: String? = null,
	@field:SerializedName("rates")
	val rates: Rates? = null,
	@field:SerializedName("timestamp")
	val timestamp: Int? = null,
	@field:SerializedName("base")
	val base: String? = null
) : BaseResponse()

@Parcelize
data class Rates(
	@field:SerializedName("JPY")
	val jPY: Double? = null,
	@field:SerializedName("EUR")
	val eUR: Int? = null,
	@field:SerializedName("GBP")
	val gBP: Double? = null
) : Parcelable
