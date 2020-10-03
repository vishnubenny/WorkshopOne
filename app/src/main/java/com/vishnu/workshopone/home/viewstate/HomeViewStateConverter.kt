package com.vishnu.workshopone.home.viewstate

import com.vishnu.core.home.api.ApiUser
import io.reactivex.rxjava3.functions.Function

class HomeViewStateConverter : Function<ApiUser, HomeViewState> {

    override fun apply(apiUser: ApiUser): HomeViewState {
        return HomeViewState.Success(apiUser)
    }
}
