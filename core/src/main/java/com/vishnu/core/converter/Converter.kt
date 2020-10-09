package com.vishnu.core.converter

interface Converter<T, R> {

    fun apply(input: T): R
}
