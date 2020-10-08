package com.vishnu.core.home

import com.vishnu.core.home.api.ApiUser
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.Deferred

interface HomeFetcher {

    suspend fun getUserAsync(): Deferred<ApiUser>

}
