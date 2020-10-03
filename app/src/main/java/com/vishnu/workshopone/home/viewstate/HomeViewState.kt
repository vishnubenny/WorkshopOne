package com.vishnu.workshopone.home.viewstate

import com.vishnu.core.home.api.ApiUser

sealed class HomeViewState {
    object Loading : HomeViewState()
    data class Success(val apiUser: ApiUser) : HomeViewState()
}
