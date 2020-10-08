package com.vishnu.workshopone.home

import com.vishnu.core.home.api.ApiUser
import com.vishnu.core.home.api.HomeApiFetcher
import kotlinx.coroutines.Deferred

class HomeRepository(private val fetcher: HomeApiFetcher) {

    suspend fun getUserAsync(): Deferred<ApiUser> {
        return fetcher.getUserAsync()
    }

}
