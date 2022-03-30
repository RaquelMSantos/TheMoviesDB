package br.com.rmso.themoviesdb.data.datasource.error

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch

internal fun <T> Flow<T>.parseError(): Flow<T> {
    return catch { throwable ->
        throw throwable
    }
}