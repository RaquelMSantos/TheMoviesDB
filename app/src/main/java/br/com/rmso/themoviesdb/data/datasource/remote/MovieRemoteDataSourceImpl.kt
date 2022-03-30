package br.com.rmso.themoviesdb.data.datasource.remote

import br.com.rmso.themoviesdb.data.model.response.MovieBaseResponse
import br.com.rmso.themoviesdb.data.retrofit.ServiceProvider
import br.com.rmso.themoviesdb.exception.MovieException
import java.lang.Exception

internal class MovieRemoteDataSourceImpl(private val serviceProvider: ServiceProvider) :
    MovieRemoteDataSource {
    override suspend fun getMovies(): MovieBaseResponse = try {
        serviceProvider.service.getMovies()
    }catch (exception: Exception) {
        throw MovieException(exception)
    }
}