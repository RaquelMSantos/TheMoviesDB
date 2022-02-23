package br.com.rmso.themoviesdb.data.repository

import br.com.rmso.themoviesdb.data.mapper.MovieEntityMapper
import br.com.rmso.themoviesdb.data.datasource.remote.MovieRemoteDataSource
import br.com.rmso.themoviesdb.domain.repository.MovieRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class MovieRepositoryImpl(
    private val remoteDataSource: MovieRemoteDataSource,
    private val movieMapper: MovieEntityMapper,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default
) : MovieRepository {
    override suspend fun getMovie(tmdbToken: String) =
        withContext(dispatcher) {
            movieMapper.map(remoteDataSource.getMovies(tmdbToken))
        }
}