package br.com.rmso.themoviesdb.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MovieBaseResponse<T>(
    @SerialName("page") val page: Int,
    @SerialName("results") val results: List<MovieResponse>,
    @SerialName("total_pages") val totalPages: Int,
    @SerialName("total_results") val totalResults: Int
)
