package com.maxab.task.core.arch

interface BaseUseCase<I, O> {
    fun execute(input: I): O
}