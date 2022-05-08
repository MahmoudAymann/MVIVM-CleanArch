package com.mayman.mvivm.feature.currencies.data.response

import com.google.gson.annotations.SerializedName
import com.google.gson.internal.LinkedTreeMap
import com.mayman.mvivm.core.network.response.BaseResponse

data class CurrenciesResponse(
    @field:SerializedName("date")
    val date: String? = null,
    @field:SerializedName("rates")
    val rates: LinkedTreeMap<String, String>? = null,
    @field:SerializedName("timestamp")
    val timestamp: Int? = null,
    @field:SerializedName("base")
    val base: String? = null
) : BaseResponse()
