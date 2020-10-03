package com.vishnu.workshopone.home

import com.vishnu.core.home.api.HomeApiFetcher
import com.vishnu.workshopone.common.viewstate.ErrorViewStateConverter
import com.vishnu.workshopone.common.viewstate.ResponseViewState
import com.vishnu.workshopone.home.viewstate.HomeViewStateConverter
import io.reactivex.rxjava3.core.Observable

class HomeRepository(
    private val fetcher: HomeApiFetcher,
    private val converter: HomeViewStateConverter,
    private val errorConverter: ErrorViewStateConverter
) {

    suspend fun getUserAsync(): Observable<ResponseViewState> {
        return fetcher.getUserAsync()
            .toObservable()
            .map(converter)
            .startWithItem(ResponseViewState.Loading)
            .compose(errorConverter)
    }

}
