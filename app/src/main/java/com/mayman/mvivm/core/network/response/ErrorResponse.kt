package com.mayman.mvivm.core.network.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ErrorResponse(
    @field:SerializedName("success")
    val success: Boolean? = null,

    @field:SerializedName("error")
    val error: Error? = null
) : Parcelable

@Parcelize
data class Error(
    @field:SerializedName("code")
    val code: Int? = null,

    @field:SerializedName("info")
    val info: String? = null
) : Parcelable