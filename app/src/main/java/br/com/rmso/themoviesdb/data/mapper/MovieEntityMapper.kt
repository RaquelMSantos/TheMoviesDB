package br.com.rmso.themoviesdb.data.mapper

import br.com.rmso.themoviesdb.data.model.response.MovieBaseResponse
import br.com.rmso.themoviesdb.data.model.response.MovieResponse
import br.com.rmso.themoviesdb.domain.entity.MovieBaseEntity
import br.com.rmso.themoviesdb.domain.entity.MovieEntity
import br.com.rmso.themoviesdb.util.Mapper

internal class MovieEntityMapper : Mapper<MovieBaseResponse, MovieBaseEntity> {
    override fun map(source: MovieBaseResponse): MovieBaseEntity {
        return MovieBaseEntity(
            page = source.page,
            results = mapMovie(source.results),
            totalPages = source.totalPages,
            totalResults = source.totalResults
        )
    }

    private fun mapMovie(results: List<MovieResponse>): List<MovieEntity> {
        return results.map {
            MovieEntity(
                adult = it.adult,
                backdropPath = it.backdropPath,
                genreIds = it.genreIds,
                id = it.id,
                originalLanguage = it.originalLanguage,
                originalTitle = it.originalTitle,
                overview = it.overview,
                popularity = it.popularity,
                posterPath = it.posterPath,
                releaseDate = it.releaseDate,
                title = it.title,
                video = it.video,
                voteAverage = it.voteAverage,
                voteCount = it.voteCount
            )
        }
    }
}
