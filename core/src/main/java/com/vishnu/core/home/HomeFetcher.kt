package com.vishnu.core.home

import com.vishnu.core.home.api.ApiUser
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.flow.Flow

interface HomeFetcher {

    suspend fun getUserAsync(): Flow<ApiUser>

}
