package com.vishnu.core.converter

interface Converter3<T1, T2, T3, R> {

    fun apply(input: T1, other1: T2, other2: T3): R
}
