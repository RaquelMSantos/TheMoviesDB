package br.com.rmso.themoviesdb.data.datasource.remote

import app.cash.turbine.test
import br.com.rmso.themoviesdb.data.retrofit.ServiceProvider
import br.com.rmso.themoviesdb.util.mockMovieBaseResponse
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test
import kotlin.time.ExperimentalTime

@ExperimentalTime
internal class MovieRemoteDataSourceImplTest {

    private val serviceProvider = mockk<ServiceProvider>()
    private val remoteDataSource = MovieRemoteDataSourceImpl(serviceProvider)

    @Test
    fun `getMovies Should return MovieBaseResponse When service is success`() = runBlocking {
        //Given
        val expectedResult = mockMovieBaseResponse()
        coEvery { serviceProvider.service.getMovies() } returns mockMovieBaseResponse()

        //When
        val result = remoteDataSource.getMovies()

        //Then
        result.test {
            assertEquals(expectedResult, awaitItem())
            awaitComplete()
        }
    }

    @Test
    fun `getMovies Should return throwable When service is failure`() = runBlocking {
        //Given
        coEvery { serviceProvider.service.getMovies() } throws Throwable()

        //When
        val result = remoteDataSource.getMovies()

        //Then
        result.test {
            assertEquals(Throwable::class.java, awaitError()::class.java)
        }
    }
}