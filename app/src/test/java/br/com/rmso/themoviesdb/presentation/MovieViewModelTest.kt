package br.com.rmso.themoviesdb.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import br.com.rmso.themoviesdb.domain.usecase.GetMovieUseCase
import br.com.rmso.themoviesdb.util.CoroutinesTestRule
import br.com.rmso.themoviesdb.util.mockListMovieEntity
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test


@ExperimentalCoroutinesApi
internal class MovieViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    private val getMovieUseCase = mockk<GetMovieUseCase>()
    private lateinit var viewModel: MovieViewModel

    @Test
    fun `init Should return success state When getMovieUseCase is success`() {
        runBlocking {
            //Given
            every { getMovieUseCase() } returns flow { emit(mockListMovieEntity()) }

            //When
            createViewModel()
            val result = viewModel.viewState.value?.isSuccess

            //Then
            verify { getMovieUseCase() }
            result?.let { assertTrue(it) }
        }
    }

    private fun createViewModel() {
        viewModel = MovieViewModel(getMovieUseCase)
    }
}