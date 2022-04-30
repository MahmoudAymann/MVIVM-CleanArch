package com.maxab.task.core.network

import com.maxab.task.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FixerInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("access_key", BuildConfig.FIXER_API_KEY)
            .build()

        // you may add request headers
        val requestBuilder = original.newBuilder()
            .url(url)
        val request = requestBuilder.build()
        return chain.proceed(request)
    }

}