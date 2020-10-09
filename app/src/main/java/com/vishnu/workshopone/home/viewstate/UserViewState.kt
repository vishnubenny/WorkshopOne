package com.vishnu.workshopone.home.viewstate

sealed class UserViewState() {
    object Loading : UserViewState()
    data class Success(val email: String) : UserViewState()
}
