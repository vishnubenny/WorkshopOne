package com.vishnu.workshopone.home

import com.vishnu.core.home.api.HomeApiFetcher
import com.vishnu.core.utils.getValue
import com.vishnu.workshopone.home.viewstate.UserViewState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

class HomeRepository(private val fetcher: HomeApiFetcher) {

    @ExperimentalCoroutinesApi
    suspend fun getUserAsync(): Flow<UserViewState> {
        return fetcher.getUserAsync()
            .map { UserViewState.Success(it.email.getValue()) }
            .onStart<UserViewState> { emit(UserViewState.Loading) }
    }

}
