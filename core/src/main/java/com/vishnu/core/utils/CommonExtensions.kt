package com.vishnu.core.utils

import com.vishnu.core.converter.BiConverter
import com.vishnu.core.converter.Converter
import com.vishnu.core.utils.Constants.EMPTY_STRING
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.zip

fun String?.getValue(default: String = EMPTY_STRING): String {
    return this ?: default
}

@Suppress("EXPERIMENTAL_API_USAGE")
fun <T> Flow<T>.startFlow(loader: T): Flow<T> {
    return this.onStart { emit(loader) }
}

fun <T, R> Flow<T>.mapper(converter: Converter<T, R>): Flow<R> {
    return this.map { converter.apply(it) }
}

fun <T> Flow<T>.onError(converter: Converter<Throwable, T>): Flow<T> {
    return this.catch { emit(converter.apply(it)) }
}

fun <T1, T2, R> Flow<T1>.zipWith(other: Flow<T2>, converter: BiConverter<T1, T2, R>): Flow<R> {
    return this.zip(other) { t1, t2 -> converter.apply(t1, t2) }
}
