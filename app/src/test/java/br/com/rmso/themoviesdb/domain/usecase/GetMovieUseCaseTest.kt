package br.com.rmso.themoviesdb.domain.usecase

import app.cash.turbine.test
import br.com.rmso.themoviesdb.domain.entity.MovieEntity
import br.com.rmso.themoviesdb.domain.repository.MovieRepository
import br.com.rmso.themoviesdb.util.mockListMovieEntity
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.test.assertFails
import kotlin.time.ExperimentalTime

@ExperimentalTime
internal class GetMovieUseCaseTest {

    private val repository = mockk<MovieRepository>()
    private val getMovieUseCase = GetMovieUseCase(repository)

    @Test
    fun `getMovieUseCase Should return List of MovieEntity When repository is success`() =
        runBlocking {
            //Given
            val expectedResult = flow<List<MovieEntity>> { mockListMovieEntity() }
            every { repository.getMovies() } returns expectedResult

            //When
            val result = getMovieUseCase()

            //Then
            result.test {
                assertEquals(expectedResult, result)
                awaitComplete()
            }
        }

    @Test
    fun `getMovieUseCase Should throw throwable When repository is failure`() = runBlocking {
        //Given
        val throwableExpected = Throwable::class.java
        every { repository.getMovies() } throws Throwable()

        //When
        val result = assertFails { getMovieUseCase() }

        //Then
        assertEquals(throwableExpected, result::class.java)

    }
}