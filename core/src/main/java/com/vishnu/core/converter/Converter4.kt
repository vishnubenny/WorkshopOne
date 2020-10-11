package com.vishnu.core.converter

interface Converter4<T1, T2, T3, T4, R> {

    fun apply(input: T1, other1: T2, other2: T3, other3: T4): R
}
