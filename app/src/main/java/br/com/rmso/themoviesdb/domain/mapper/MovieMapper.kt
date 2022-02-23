package br.com.rmso.themoviesdb.domain.mapper

import br.com.rmso.themoviesdb.domain.entity.MovieBaseEntity
import br.com.rmso.themoviesdb.domain.entity.MovieEntity
import br.com.rmso.themoviesdb.presentation.model.Movie
import br.com.rmso.themoviesdb.presentation.model.MovieBase
import br.com.rmso.themoviesdb.util.Mapper

class MovieMapper : Mapper<MovieBaseEntity, MovieBase> {
    override fun map(source: MovieBaseEntity): MovieBase {
        return MovieBase(
            page = source.page,
            results = mapResults(source.results),
            totalPages = source.totalPages,
            totalResults = source.totalResults
        )
    }

    private fun mapResults(results: List<MovieEntity>): List<Movie> {
        return results.map {
            Movie(
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