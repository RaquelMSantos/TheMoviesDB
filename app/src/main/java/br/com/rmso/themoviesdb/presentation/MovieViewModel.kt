package br.com.rmso.themoviesdb.presentation

import androidx.lifecycle.*
import br.com.rmso.themoviesdb.domain.entity.MovieEntity
import br.com.rmso.themoviesdb.domain.usecase.GetMovieUseCase
import br.com.rmso.themoviesdb.presentation.model.Movie
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

internal class MovieViewModel(
    private val getMovieUseCase: GetMovieUseCase,
) : ViewModel() {

    init {
        getMovies()
    }

    private val _movies = MutableLiveData<List<Movie>>()
    val movies = _movies as LiveData<List<Movie>>

    private val _viewState =
        MutableLiveData<Result<Boolean>>().apply { value = Result.success(false) }
    val viewState: LiveData<Result<Boolean>>
        get() = _viewState

    fun getMovies() {
        viewModelScope.launch {
            getMovieUseCase()
                .onStart { showLoading() }
                .catch {
                    _viewState.postValue(Result.failure(it))
                }
                .onCompletion { hideLoading() }
                .collect { showMoviesSuccess(it) }
        }
    }

    private fun hideLoading() { }

    private fun showLoading() { }

    private fun showMoviesSuccess(listMovie: List<MovieEntity>) {
        _movies.postValue(listMovie.map { movieEntity ->
            Movie(movieEntity)
        })
        _viewState.postValue(Result.success(true))
    }
}