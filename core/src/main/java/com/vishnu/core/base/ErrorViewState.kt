package com.vishnu.core.base

import com.vishnu.core.converter.Converter
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

class ErrorViewStateConverter : Converter<Throwable, BaseViewState> {
    override fun apply(input: Throwable): BaseViewState {
        return BaseViewState.Error(errorViewState(input))
    }

    private fun errorViewState(throwable: Throwable): ErrorViewState {
        return when (throwable) {
            is UnknownHostException -> ErrorViewState(ErrorType.NO_INTERNET)
            else -> ErrorViewState(ErrorType.UNKNOWN)
        }
    }
}
