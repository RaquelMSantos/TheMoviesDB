package br.com.rmso.themoviesdb.data.datasource.remote

import br.com.rmso.themoviesdb.data.model.response.MovieBaseResponse
import br.com.rmso.themoviesdb.data.model.response.MovieResponse

internal interface MovieRemoteDataSource {
    suspend fun getMovies(): MovieBaseResponse<List<MovieResponse>>
}