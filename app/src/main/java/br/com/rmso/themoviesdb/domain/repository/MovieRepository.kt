package br.com.rmso.themoviesdb.domain.repository

import br.com.rmso.themoviesdb.domain.entity.MovieBaseEntity

internal interface MovieRepository {
    suspend fun getMovie(tmdbToken: String): MovieBaseEntity
}