package br.com.rmso.themoviesdb.data.api

import br.com.rmso.themoviesdb.data.model.response.MovieBaseResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface MovieService {
    @GET("discover/movie")
    suspend fun getMovies(@Query("api_key") tmdbToken: String): MovieBaseResponse
}