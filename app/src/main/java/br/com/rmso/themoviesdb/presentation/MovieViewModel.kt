package br.com.rmso.themoviesdb.presentation

import androidx.lifecycle.*
import br.com.rmso.themoviesdb.domain.usecase.GetMovieUseCase
import br.com.rmso.themoviesdb.presentation.model.Movie
import kotlinx.coroutines.launch

internal class MovieViewModel(
    private val getMovieUseCase: GetMovieUseCase,
) : ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>()
    val movies = _movies as LiveData<List<Movie>>

    init {
        getMovies()
    }

    private fun getMovies() {
        viewModelScope.launch {
            getMovieUseCase().onSuccess {
                val movies: List<Movie> = it.map { movieEntity ->
                    Movie(movieEntity)
                }

                _movies.postValue(movies)
            }.onFailure {

            }
        }
    }
}