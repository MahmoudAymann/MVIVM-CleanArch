package com.maxab.task.core.network.response

import com.google.gson.annotations.SerializedName

open class BaseResponse(
    val success: Boolean? = null,
    @field:SerializedName("error")
    val error: Error? = null
)