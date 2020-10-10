package com.vishnu.core.utils

import com.vishnu.core.converter.Converter
import com.vishnu.core.utils.Constants.EMPTY_STRING
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

fun String?.getValue(default: String = EMPTY_STRING): String {
    return this ?: default
}

fun <T, R> Flow<T>.mapper(converter: Converter<T, R>): Flow<R> {
    return this.map { converter.apply(it) }
}
