package com.vishnu.workshopone.home

import com.vishnu.core.home.api.HomeApiFetcher
import com.vishnu.core.utils.getValue
import com.vishnu.workshopone.home.viewstate.UserViewState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class HomeRepository(private val fetcher: HomeApiFetcher) {

    suspend fun getUserAsync(): Flow<UserViewState> {
        return fetcher.getUserAsync()
            .map { UserViewState(it.email.getValue()) }
    }

}
