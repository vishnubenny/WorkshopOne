package com.vishnu.workshopone.home

import com.vishnu.core.base.BaseViewState
import com.vishnu.core.base.ErrorViewStateConverter
import com.vishnu.core.home.api.HomeApiFetcher
import com.vishnu.core.utils.mapper
import com.vishnu.core.utils.startFlow
import com.vishnu.workshopone.home.viewstate.UserViewStateConverter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch

class HomeRepository(
    private val fetcher: HomeApiFetcher,
    private val converter: UserViewStateConverter
) {

    suspend fun getUserAsync(): Flow<BaseViewState> {
        return fetcher.getUserAsync()
            .mapper(converter)
            .startFlow(BaseViewState.Loading)
            .catch { emit(BaseViewState.Error(ErrorViewStateConverter.apply(it))) }
    }

}
