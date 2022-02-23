package br.com.rmso.themoviesdb.domain.usecase

import br.com.rmso.themoviesdb.domain.entity.MovieBaseEntity
import br.com.rmso.themoviesdb.domain.repository.MovieRepository

internal class GetMovieUseCase(val repository: MovieRepository) {
    suspend operator fun invoke(tmdbToken: String): MovieBaseEntity = repository.getMovie(tmdbToken)
}