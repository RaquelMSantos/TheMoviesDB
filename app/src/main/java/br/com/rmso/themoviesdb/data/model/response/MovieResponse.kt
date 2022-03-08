package br.com.rmso.themoviesdb.data.model.response

import br.com.rmso.themoviesdb.domain.entity.MovieEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MovieResponse(
    @SerialName("adult") val adult: Boolean,
    @SerialName("backdrop_path") val backdropPath: String?,
    @SerialName("genre_ids") val genreIds: List<Int>?,
    @SerialName("id") val id: Int,
    @SerialName("original_language") val originalLanguage: String?,
    @SerialName("original_title") val originalTitle: String?,
    @SerialName("overview") val overview: String,
    @SerialName("popularity") val popularity: Double,
    @SerialName("poster_path") val posterPath: String?,
    @SerialName("release_date") val releaseDate: String?,
    @SerialName("title") val title: String,
    @SerialName("video") val video: Boolean,
    @SerialName("vote_average") val voteAverage: Double,
    @SerialName("vote_count") val voteCount: Int
)

internal fun MovieResponse.toDomain() = MovieEntity(
    adult = this.adult,
    backdropPath = this.backdropPath,
    genreIds = this.genreIds,
    id = this.id,
    originalLanguage = this.originalLanguage,
    originalTitle = this.originalTitle,
    overview = this.overview,
    popularity = this.popularity,
    posterPath = this.posterPath,
    releaseDate = this.releaseDate,
    title = this.title,
    video = this.video,
    voteAverage = this.voteAverage,
    voteCount = this.voteCount
)



