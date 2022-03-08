package br.com.rmso.themoviesdb.data.retrofit

import br.com.rmso.themoviesdb.data.api.MovieService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val baseUrl = "https://api.themoviedb.org/3/"

class ServiceProvider {

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    internal val service = retrofit.create(MovieService::class.java)
}