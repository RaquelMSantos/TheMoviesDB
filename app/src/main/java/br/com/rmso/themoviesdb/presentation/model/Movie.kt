package br.com.rmso.themoviesdb.presentation.model

import br.com.rmso.themoviesdb.domain.entity.MovieEntity

internal data class Movie(
    val id: Int,
    val backdropPath: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double
) {
    constructor(movie: MovieEntity) : this(
        id = movie.id,
        backdropPath = movie.backdropPath,
        overview = movie.overview,
        popularity = movie.popularity,
        posterPath = movie.posterPath,
        releaseDate = movie.releaseDate,
        title = movie.title,
        video = movie.video,
        voteAverage = movie.voteAverage
    )
}