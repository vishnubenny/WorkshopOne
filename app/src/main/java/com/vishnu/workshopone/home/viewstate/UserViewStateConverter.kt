package com.vishnu.workshopone.home.viewstate

import com.vishnu.core.converter.Converter
import com.vishnu.core.home.api.ApiUser
import com.vishnu.core.utils.getValue

class UserViewStateConverter : Converter<ApiUser, UserViewState> {

    override fun apply(input: ApiUser): UserViewState {
        return UserViewState(input.email.getValue())
    }
}
