package com.example.usecases

import kotlinx.coroutines.flow.Flow

abstract class FlowUseCase<T, R> {

     abstract fun prepareFlow(input: T): Flow<R>
}