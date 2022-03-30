package br.com.rmso.themoviesdb.data.repository

import br.com.rmso.themoviesdb.data.datasource.remote.MovieRemoteDataSource
import br.com.rmso.themoviesdb.data.model.response.toDomain
import br.com.rmso.themoviesdb.domain.entity.MovieEntity
import br.com.rmso.themoviesdb.domain.repository.MovieRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class MovieRepositoryImpl(
    private val remoteDataSource: MovieRemoteDataSource,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : MovieRepository {
    override suspend fun getMovies(): List<MovieEntity> =
        withContext(dispatcher) {
            remoteDataSource.getMovies().results.map {
                it.toDomain()
            }
        }
}