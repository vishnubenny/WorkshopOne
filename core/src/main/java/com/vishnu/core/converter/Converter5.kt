package com.vishnu.core.converter

interface Converter5<T1, T2, T3, T4, T5, R> {

    fun apply(input: T1, other1: T2, other2: T3, other3: T4, other4: T5): R
}
