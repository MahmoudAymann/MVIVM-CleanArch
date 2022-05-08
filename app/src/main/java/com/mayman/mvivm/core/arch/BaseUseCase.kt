package com.mayman.mvivm.core.arch

abstract class BaseUseCase<I, O> {
    abstract suspend fun execute(input: I): O
}