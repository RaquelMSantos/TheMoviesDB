package br.com.rmso.themoviesdb.data.datasource.remote

import br.com.rmso.themoviesdb.data.model.response.MovieBaseResponse

internal interface MovieRemoteDataSource {
    suspend fun getMovies(tmdbToken: String): MovieBaseResponse
}