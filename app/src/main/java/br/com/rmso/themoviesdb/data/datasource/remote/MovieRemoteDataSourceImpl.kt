package br.com.rmso.themoviesdb.data.datasource.remote

import br.com.rmso.themoviesdb.data.datasource.error.parseError
import br.com.rmso.themoviesdb.data.model.response.MovieBaseResponse
import br.com.rmso.themoviesdb.data.retrofit.ServiceProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class MovieRemoteDataSourceImpl(private val serviceProvider: ServiceProvider) :
    MovieRemoteDataSource {
    override fun getMovies(): Flow<MovieBaseResponse> {
        return flow { emit(serviceProvider.service.getMovies()) }.parseError()
    }
}