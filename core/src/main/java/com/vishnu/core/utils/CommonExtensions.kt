package com.vishnu.core.utils

import com.vishnu.core.converter.Converter
import com.vishnu.core.utils.Constants.EMPTY_STRING
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

fun String?.getValue(default: String = EMPTY_STRING): String {
    return this ?: default
}

@Suppress("EXPERIMENTAL_API_USAGE")
fun <T> Flow<T>.startFlow(loader: T): Flow<T> {
    return this.onStart<T> { emit(loader) }
}

fun <T, R> Flow<T>.mapper(converter: Converter<T, R>): Flow<R> {
    return this.map { converter.apply(it) }
}
