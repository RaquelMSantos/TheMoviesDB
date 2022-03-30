package br.com.rmso.themoviesdb.domain.repository

import br.com.rmso.themoviesdb.domain.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

internal interface MovieRepository {
    fun getMovies(): Flow<List<MovieEntity>>
}