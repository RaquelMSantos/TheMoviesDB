package br.com.rmso.themoviesdb.domain.repository

import br.com.rmso.themoviesdb.domain.entity.MovieEntity

internal interface MovieRepository {
    suspend fun getMovies(): List<MovieEntity>
}