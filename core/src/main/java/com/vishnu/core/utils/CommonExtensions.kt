package com.vishnu.core.utils

import com.vishnu.core.utils.Constants.EMPTY_STRING

fun String?.getValue(default: String = EMPTY_STRING): String {
    return this ?: default
}
