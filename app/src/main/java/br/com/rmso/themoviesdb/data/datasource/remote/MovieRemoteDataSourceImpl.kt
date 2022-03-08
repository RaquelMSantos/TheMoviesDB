package br.com.rmso.themoviesdb.data.datasource.remote

import br.com.rmso.themoviesdb.BuildConfig
import br.com.rmso.themoviesdb.data.model.response.MovieBaseResponse
import br.com.rmso.themoviesdb.data.retrofit.ServiceProvider

internal class MovieRemoteDataSourceImpl(private val serviceProvider: ServiceProvider) :
    MovieRemoteDataSource {
    override suspend fun getMovies(): MovieBaseResponse {
        return serviceProvider.service.getMovies(BuildConfig.tmdbToken)
    }
}