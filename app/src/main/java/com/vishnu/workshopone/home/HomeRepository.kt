package com.vishnu.workshopone.home

import com.vishnu.core.base.BaseViewState
import com.vishnu.core.base.ErrorViewStateConverter
import com.vishnu.core.home.api.HomeApiFetcher
import com.vishnu.workshopone.home.viewstate.UserViewStateConverter
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

class HomeRepository(
    private val fetcher: HomeApiFetcher,
    private val converter: UserViewStateConverter
) {

    @ExperimentalCoroutinesApi
    suspend fun getUserAsync(): Flow<BaseViewState> {
        return fetcher.getUserAsync()
            .map { BaseViewState.Success(converter.apply(it)) }
            .onStart<BaseViewState> { emit(BaseViewState.Loading) }
            .catch { emit(BaseViewState.Error(ErrorViewStateConverter.apply(it))) }
    }

}
