package br.com.rmso.themoviesdb.domain.usecase

import br.com.rmso.themoviesdb.domain.entity.MovieEntity
import br.com.rmso.themoviesdb.domain.repository.MovieRepository

internal class GetMovieUseCase(private val repository: MovieRepository) {
    suspend operator fun invoke(): Result<List<MovieEntity>> {
        return try {
            Result.success(repository.getMovies())
        } catch (throwable: Throwable) {
            Result.failure(throwable)
        }
    }
}