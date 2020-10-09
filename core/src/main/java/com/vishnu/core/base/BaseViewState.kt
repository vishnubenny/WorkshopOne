package com.vishnu.core.base

sealed class BaseViewState {
    object Loading : BaseViewState()
    data class Success<T>(val data: T) : BaseViewState()
    data class Error(val errorViewState: ErrorViewState) : BaseViewState()
}
