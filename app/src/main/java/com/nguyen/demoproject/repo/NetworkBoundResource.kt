package com.nguyen.demoproject.repo

import com.nguyen.demoproject.utils.UIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

inline fun <DomainType> getNetworkBoundResource(
    crossinline query: () -> DomainType,
    crossinline fetch: suspend () -> DomainType?,
    crossinline saveFetchResult: suspend (DomainType?) -> Unit,
    crossinline shouldFetch: (DomainType?) -> Boolean = { true },
): Flow<UIState<DomainType>> {
    return flow {
        try {
            emit(UIState.Loading<DomainType>())

            val cacheData = query()

            if(cacheData != null){
                emit(UIState.Loaded<DomainType>(cacheData))
            }

            if(shouldFetch(cacheData)){
                saveFetchResult(fetch())

                val newCache = query()
                emit(UIState.Loaded(newCache))
            }
        } catch (exception: Throwable){
            emit(UIState.Error<DomainType>(exception.message ?: "Something went wrong"))
        }

    }
}