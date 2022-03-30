package br.com.rmso.themoviesdb.util

import br.com.rmso.themoviesdb.data.model.response.MovieBaseResponse
import br.com.rmso.themoviesdb.data.model.response.MovieResponse
import br.com.rmso.themoviesdb.domain.entity.MovieEntity

internal fun mockMovieBaseResponse(): MovieBaseResponse {
    return MovieBaseResponse(
        page = 0,
        results = listOf(MovieResponse(
            adult = false,
            backdropPath = "/iQFcwSGbZXMkeyKrxbPnwnRo5fl.jpg",
            genreIds = listOf(28, 12, 878),
            id = 634649,
            originalLanguage = "en",
            originalTitle = "Spider-Man",
            overview = "Peter Paker is unmasked",
            popularity = 10552.0,
            posterPath = "/iQFcwSGbZXMkeyKrxbPnwnRo5fl.jpg",
            releaseDate = "2021-12-15",
            title = "Spider-Man: No Way Home",
            video = false,
            voteAverage = 8.3,
            voteCount = 9461
        )),
        totalPages = 0,
        totalResults = 0
    )
}

internal fun mockListMovieEntity(): List<MovieEntity> {
    return listOf(
        MovieEntity(
            adult = false,
            backdropPath = "/iQFcwSGbZXMkeyKrxbPnwnRo5fl.jpg",
            genreIds = listOf(28, 12, 878),
            id = 634649,
            originalLanguage = "en",
            originalTitle = "Spider-Man",
            overview = "Peter Paker is unmasked",
            popularity = 10552.0,
            posterPath = "/iQFcwSGbZXMkeyKrxbPnwnRo5fl.jpg",
            releaseDate = "2021-12-15",
            title = "Spider-Man: No Way Home",
            video = false,
            voteAverage = 8.3,
            voteCount = 9461
        )
    )
}