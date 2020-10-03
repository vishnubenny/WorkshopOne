package com.vishnu.core.home.api

import com.vishnu.core.home.HomeFetcher
import io.reactivex.rxjava3.core.Single

class HomeApiFetcher(private val backend: HomeBackend) : HomeFetcher {

    override suspend fun getUserAsync(): Single<ApiUser> {
        return Single.just(backend.getUserAsync().await())
    }
}
