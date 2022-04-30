package com.maxab.task.core.arch

abstract class BaseUseCase<I, O> {
    abstract suspend fun execute(input: I): O
}