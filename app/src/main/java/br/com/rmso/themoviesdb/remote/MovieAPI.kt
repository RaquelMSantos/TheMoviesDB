package br.com.rmso.themoviesdb.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {

    @GET("discover/movie")
    suspend fun getMovies(@Query("api_key") tmdbToken: String): BaseResponse<List<MovieResponse>>
}