package com.vishnu.workshopone.home.viewstate

import com.vishnu.core.utils.Constants.EMPTY_STRING

data class UserViewState(val email: String) {

    companion object {
        val EMPTY = UserViewState(EMPTY_STRING)
    }
}
