package com.vishnu.workshopone.common.viewstate

sealed class ResponseViewState {

    data class Success<T>(val data: T) : ResponseViewState()
    object Error : ResponseViewState()
}
