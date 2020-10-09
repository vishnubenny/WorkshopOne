package com.vishnu.core.base

import java.net.UnknownHostException

data class ErrorViewState(val errorType: ErrorType) {

    companion object {
        val EMPTY = ErrorViewState(ErrorType.EMPTY)
    }
}

enum class ErrorType {
    EMPTY,
    NO_INTERNET,
    UNKNOWN
}

object ErrorViewStateConverter {
    fun apply(throwable: Throwable): ErrorViewState {
        return when (throwable) {
            is UnknownHostException -> ErrorViewState(ErrorType.NO_INTERNET)
            else -> ErrorViewState(ErrorType.UNKNOWN)
        }
    }
}
