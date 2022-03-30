package br.com.rmso.themoviesdb.domain.usecase

import br.com.rmso.themoviesdb.domain.entity.MovieEntity
import br.com.rmso.themoviesdb.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

internal class GetMovieUseCase(private val repository: MovieRepository) {
    operator fun invoke(): Flow<List<MovieEntity>> = repository.getMovies()
}