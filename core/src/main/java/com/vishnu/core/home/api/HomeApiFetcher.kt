package com.vishnu.core.home.api

import com.vishnu.core.home.HomeFetcher
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.Deferred

class HomeApiFetcher(private val backend: HomeBackend) : HomeFetcher {

    override suspend fun getUserAsync(): Deferred<ApiUser> {
        return backend.getUserAsync()
    }
}
