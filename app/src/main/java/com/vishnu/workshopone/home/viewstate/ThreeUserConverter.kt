package com.vishnu.workshopone.home.viewstate

import com.vishnu.core.base.BaseViewState
import com.vishnu.core.converter.Converter3
import com.vishnu.core.home.api.ApiUser
import com.vishnu.core.utils.getValue

class ThreeUserConverter : Converter3<ApiUser, ApiUser, ApiUser, BaseViewState> {

    override fun apply(input: ApiUser, other1: ApiUser, other2: ApiUser): BaseViewState {
        return BaseViewState.Success(userViewStateFrom(other2))
    }

    private fun userViewStateFrom(other2: ApiUser): UserViewState {
        return UserViewState(other2.email.getValue())
    }
}
