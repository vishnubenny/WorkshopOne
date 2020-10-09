package com.vishnu.core.base

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
        return ErrorViewState(ErrorType.UNKNOWN)
    }
}
