package com.vishnu.core.utils

import com.vishnu.core.converter.BiConverter
import com.vishnu.core.converter.Converter
import com.vishnu.core.converter.Converter3
import com.vishnu.core.converter.Converter4
import com.vishnu.core.converter.Converter5
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.zip

@Suppress("EXPERIMENTAL_API_USAGE")
fun <T> Flow<T>.startFlow(loader: T): Flow<T> {
    return this.onStart { emit(loader) }
}

fun <T> Flow<T>.onError(converter: Converter<Throwable, T>): Flow<T> {
    return this.catch { emit(converter.apply(it)) }
}

fun <T, R> Flow<T>.mapper(converter: Converter<T, R>): Flow<R> {
    return this.map { converter.apply(it) }
}

fun <T1, T2, R> Flow<T1>.zipWith(other: Flow<T2>, converter: BiConverter<T1, T2, R>): Flow<R> {
    return this.zip(other) { t1, t2 -> converter.apply(t1, t2) }
}

fun <T1, T2, T3, R> Flow<T1>.combineLatest(
    other1: Flow<T2>,
    other2: Flow<T3>,
    converter3: Converter3<T1, T2, T3, R>
): Flow<R> {
    return combine(flow = this, other1, other2) { t1, t2, t3 -> converter3.apply(t1, t2, t3) }
}

fun <T1, T2, T3, T4, R> Flow<T1>.combineLatest(
    other1: Flow<T2>,
    other2: Flow<T3>,
    other3: Flow<T4>,
    converter4: Converter4<T1, T2, T3, T4, R>
): Flow<R> {
    return combine(flow = this, other1, other2, other3) { t1, t2, t3, t4 ->
        converter4.apply(t1, t2, t3, t4)
    }
}

fun <T1, T2, T3, T4, T5, R> Flow<T1>.combineLatest(
    other1: Flow<T2>,
    other2: Flow<T3>,
    other3: Flow<T4>,
    other4: Flow<T5>,
    converter5: Converter5<T1, T2, T3, T4, T5, R>
): Flow<R> {
    return combine(flow = this, other1, other2, other3, other4) { t1, t2, t3, t4, t5 ->
        converter5.apply(t1, t2, t3, t4, t5)
    }
}
