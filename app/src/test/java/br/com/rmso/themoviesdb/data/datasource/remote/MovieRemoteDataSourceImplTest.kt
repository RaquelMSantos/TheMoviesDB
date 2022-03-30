package br.com.rmso.themoviesdb.data.datasource.remote

import br.com.rmso.themoviesdb.data.model.response.MovieBaseResponse
import br.com.rmso.themoviesdb.data.retrofit.ServiceProvider
import br.com.rmso.themoviesdb.exception.MovieException
import br.com.rmso.themoviesdb.presentation.model.Movie
import br.com.rmso.themoviesdb.util.mockMovieBaseResponse
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.hamcrest.core.IsInstanceOf
import org.junit.Assert.*
import org.junit.Test
import java.lang.Exception
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
        coVerify { serviceProvider.service.getMovies() }
        assertEquals(expectedResult, result)
    }

    @Test(expected = MovieException::class)
    fun `getMovies Should return throwable When service is failure`() {
        runBlocking {
            //Given
            val expectedException = MovieException()
            coEvery { serviceProvider.service.getMovies() } throws expectedException

            //When
            remoteDataSource.getMovies()
        }
    }
}