package br.com.rmso.themoviesdb.presentation.model

internal data class MovieBase(
    val page: Int,
    val results: List<Movie>,
    val totalPages: Int,
    val totalResults: Int
)