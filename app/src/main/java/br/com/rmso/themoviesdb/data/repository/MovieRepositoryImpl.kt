package br.com.rmso.themoviesdb.data.repository

import br.com.rmso.themoviesdb.data.datasource.remote.MovieRemoteDataSource
import br.com.rmso.themoviesdb.data.model.response.toDomain
import br.com.rmso.themoviesdb.domain.entity.MovieEntity
import br.com.rmso.themoviesdb.domain.repository.MovieRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

internal class MovieRepositoryImpl(
    private val remoteDataSource: MovieRemoteDataSource,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : MovieRepository {
    override fun getMovies(): Flow<List<MovieEntity>> =
        remoteDataSource.getMovies()
            .map { movieResponse -> movieResponse.results.map { it.toDomain() } }
            .flowOn(dispatcher)
}