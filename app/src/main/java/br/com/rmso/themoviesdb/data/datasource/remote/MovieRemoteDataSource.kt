package br.com.rmso.themoviesdb.data.datasource.remote

import br.com.rmso.themoviesdb.data.model.response.MovieBaseResponse
import kotlinx.coroutines.flow.Flow

internal interface MovieRemoteDataSource {
    fun getMovies(): Flow<MovieBaseResponse>
}