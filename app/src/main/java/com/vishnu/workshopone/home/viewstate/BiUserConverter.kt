package com.vishnu.workshopone.home.viewstate

import com.vishnu.core.base.BaseViewState
import com.vishnu.core.converter.BiConverter
import com.vishnu.core.home.api.ApiUser
import com.vishnu.core.utils.getValue

class BiUserConverter : BiConverter<ApiUser, ApiUser, BaseViewState> {

    override fun apply(input: ApiUser, other: ApiUser): BaseViewState {
        return BaseViewState.Success(userViewStateFrom(other))
    }

    private fun userViewStateFrom(other: ApiUser): UserViewState {
        return UserViewState(other.email.getValue())
    }
}
