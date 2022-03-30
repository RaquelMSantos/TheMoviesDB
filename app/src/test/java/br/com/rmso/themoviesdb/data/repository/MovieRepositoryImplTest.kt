package br.com.rmso.themoviesdb.data.repository

import app.cash.turbine.test
import br.com.rmso.themoviesdb.util.CoroutinesTestRule
import br.com.rmso.themoviesdb.data.datasource.remote.MovieRemoteDataSource
import br.com.rmso.themoviesdb.util.mockListMovieEntity
import br.com.rmso.themoviesdb.util.mockMovieBaseResponse
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import kotlin.time.ExperimentalTime

@ExperimentalCoroutinesApi
@ExperimentalTime
internal class MovieRepositoryImplTest {

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    private val remoteDataSource = mockk<MovieRemoteDataSource>()
    private val repository =
        MovieRepositoryImpl(remoteDataSource, coroutinesTestRule.testDispatcher)

    @Test
    fun `getMovies Should return List of MovieEntity When data source return success`() = runBlocking {
        //Given
        val expectedResult = mockListMovieEntity()
        every { remoteDataSource.getMovies() } returns flow {emit(mockMovieBaseResponse()) }

        //When
        val result = repository.getMovies()

        //Then
        result.test {
            assertEquals(expectedResult, awaitItem())
            awaitComplete()
        }
    }
}