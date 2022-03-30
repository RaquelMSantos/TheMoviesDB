package br.com.rmso.themoviesdb.domain.usecase

import br.com.rmso.themoviesdb.domain.repository.MovieRepository
import br.com.rmso.themoviesdb.util.mockListMovieEntity
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

internal class GetMovieUseCaseTest {

    private val repository = mockk<MovieRepository>()
    private val getMovieUseCase = GetMovieUseCase(repository)

    @Test
    fun `getMovieUseCase Should return List of MovieEntity When repository is success`() = runBlocking {
        //Given
        val expectedResult = mockListMovieEntity()
        coEvery { repository.getMovies() } returns expectedResult

        //When
        val result = getMovieUseCase.invoke()

        //Then
        assertEquals(Result.success(expectedResult), result)
    }
}