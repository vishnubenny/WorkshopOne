package com.vishnu.workshopone.home

import com.vishnu.core.base.BaseViewState
import com.vishnu.core.base.ErrorViewStateConverter
import com.vishnu.core.home.api.HomeApiFetcher
import com.vishnu.core.utils.mapper
import com.vishnu.core.utils.onError
import com.vishnu.core.utils.startFlow
import com.vishnu.workshopone.home.viewstate.UserViewStateConverter
import kotlinx.coroutines.flow.Flow

class HomeRepository(
    private val fetcher: HomeApiFetcher,
    private val converter: UserViewStateConverter,
    private val errorViewStateConverter: ErrorViewStateConverter
) {

    suspend fun getUserAsync(): Flow<BaseViewState> {
        return fetcher.getUserAsync()
            .mapper(converter)
            .startFlow(BaseViewState.Loading)
            .onError(errorViewStateConverter)
    }

}
