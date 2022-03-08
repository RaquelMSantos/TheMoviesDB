package br.com.rmso.themoviesdb.presentation

import androidx.lifecycle.*
import br.com.rmso.themoviesdb.domain.usecase.GetMovieUseCase
import br.com.rmso.themoviesdb.presentation.model.Movie
import br.com.rmso.themoviesdb.presentation.model.ViewState
import kotlinx.coroutines.launch

internal class MovieViewModel(
    private val getMovieUseCase: GetMovieUseCase,
) : ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>()
    val movies = _movies as LiveData<List<Movie>>

    private val _viewState = MutableLiveData<ViewState>()
    val viewState: LiveData<ViewState> = _viewState

    fun getMovies() {
        _viewState.postValue(ViewState.LOADING)

        viewModelScope.launch {
            getMovieUseCase().onSuccess {
                _movies.postValue(it.map { movieEntity ->
                    Movie(movieEntity)
                })

                _viewState.postValue(ViewState.SUCCESS)
            }.onFailure {
                _viewState.postValue(ViewState.ERROR)
            }
        }
    }
}