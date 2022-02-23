package br.com.rmso.themoviesdb.domain.entity

internal data class MovieBaseEntity (
    val page: Int,
    val results: List<MovieEntity>,
    val totalPages: Int,
    val totalResults: Int
)