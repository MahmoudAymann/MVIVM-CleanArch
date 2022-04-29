package com.maxab.task.core.arch

abstract class BaseUseCase<I, O> {
    abstract fun execute(input: I): O
}