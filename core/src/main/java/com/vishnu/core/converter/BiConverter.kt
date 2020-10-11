package com.vishnu.core.converter

interface BiConverter<T1, T2, R> {

    fun apply(input: T1, other: T2): R
}
