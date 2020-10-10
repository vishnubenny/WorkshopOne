package com.vishnu.workshopone.home.viewstate

import com.vishnu.core.base.BaseViewState
import com.vishnu.core.converter.Converter
import com.vishnu.core.home.api.ApiUser
import com.vishnu.core.utils.getValue

class UserViewStateConverter : Converter<ApiUser, BaseViewState.Success<UserViewState>> {

    override fun apply(input: ApiUser): BaseViewState.Success<UserViewState> {
        return BaseViewState.Success(userViewState(input))
    }

    private fun userViewState(input: ApiUser): UserViewState {
        return UserViewState(input.email.getValue())
    }
}
