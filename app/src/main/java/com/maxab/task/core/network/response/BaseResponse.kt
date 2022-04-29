package com.maxab.task.core.network.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
open class BaseResponse(
    val success: Boolean? = null
) : Parcelable