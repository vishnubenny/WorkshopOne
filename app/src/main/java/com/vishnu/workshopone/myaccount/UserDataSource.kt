package com.vishnu.workshopone.myaccount

import com.vishnu.workshopone.home.viewstate.UserViewState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOf

@Suppress("EXPERIMENTAL_API_USAGE")
class UserDataSource {

    private val subject = MutableStateFlow(UserViewState.EMPTY)

    fun save(userViewState: UserViewState) {
        subject.value = userViewState
    }

    fun flowSubject(): Flow<UserViewState> {
        return subject.distinctUntilChanged { old, new -> old == new }
    }

    fun setDefaults() {
        subject.value = UserViewState.EMPTY
    }

}
