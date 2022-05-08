package com.mayman.mvivm.core.network

// A generic class that contains data and status about loading this data.
sealed class NetworkResource<T> {
    data class Success<T>(val data: T) : NetworkResource<T>()
    data class Failure<T>(val message: String?) : NetworkResource<T>()

    companion object {
        fun <T> success(data: T): NetworkResource<T> = Success(data)
        fun <T> failure(e: String?): NetworkResource<T> = Failure(e)
    }
}
