package com.vishnu.core.home.api

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface HomeBackend {

    @GET("placeholder/user/1")
    fun getUserAsync(): Deferred<ApiUser>

}
