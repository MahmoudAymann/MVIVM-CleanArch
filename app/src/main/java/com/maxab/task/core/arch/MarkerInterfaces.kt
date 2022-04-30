package com.maxab.task.core.arch

import javax.inject.Qualifier


interface UiState

/*
* Marker interface for query classes
* */
interface HashMapParams {
    fun dataClass(): Any
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AuthInterceptorOkHttpClient
