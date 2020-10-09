package com.vishnu.core.home.api

import com.vishnu.core.home.HomeFetcher
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class HomeApiFetcher(private val backend: HomeBackend) : HomeFetcher {

    override suspend fun getUserAsync(): Flow<ApiUser> {
        return flow { emit(backend.getUserAsync().await()) }
            .flowOn(IO)
    }
}
