package br.com.rmso.themoviesdb.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.rmso.themoviesdb.domain.mapper.MovieMapper
import br.com.rmso.themoviesdb.domain.usecase.GetMovieUseCase
import kotlinx.coroutines.launch

internal class MovieViewModel(
    private val getMovieUseCase: GetMovieUseCase,
    private val movieMapper: MovieMapper
) : ViewModel() {

    init {
        getMovies()
    }

    private fun getMovies() {
        viewModelScope.launch {
            getMovieUseCase("")
                .runCatching {

                }
                .onSuccess {

                }
                .onFailure {

                }
        }
    }
}