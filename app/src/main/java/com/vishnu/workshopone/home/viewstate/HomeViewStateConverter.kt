package com.vishnu.workshopone.home.viewstate

import com.vishnu.core.home.api.ApiUser
import com.vishnu.workshopone.common.viewstate.ResponseViewState
import io.reactivex.rxjava3.functions.Function

class HomeViewStateConverter : Function<ApiUser, ResponseViewState> {

    override fun apply(apiUser: ApiUser): ResponseViewState {
        return ResponseViewState.Success(apiUser)
    }
}
