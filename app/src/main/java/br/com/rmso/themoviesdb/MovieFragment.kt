package br.com.rmso.themoviesdb

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import br.com.rmso.themoviesdb.remote.BaseResponse
import br.com.rmso.themoviesdb.remote.CustomError
import br.com.rmso.themoviesdb.remote.MovieResponse
import br.com.rmso.themoviesdb.remote.ServiceProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import retrofit2.HttpException
import java.lang.Exception
import java.net.HttpURLConnection

class MovieFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    private fun getMovies() {
        lifecycleScope.launch(Dispatchers.IO) {
            try {

                val result: BaseResponse<List<MovieResponse>> =
                    ServiceProvider.service.getMovies(BuildConfig.tmdbToken)

                withContext(Dispatchers.Main) {
                    //movies.adapter = MoviesAdapter(value.results)
                }
            } catch (exception: HttpException) {
                when (exception.code()) {
                    HttpURLConnection.HTTP_BAD_REQUEST -> {
                        // error 400
                    }
                    HttpURLConnection.HTTP_NOT_FOUND -> {
                        // error 404
                    }
                    HttpURLConnection.HTTP_INTERNAL_ERROR -> {
                        // error 500
                    }
                    else -> {
                        //some other error
                    }
                }
                val error = exception.getErrorResponse<CustomError>()


            } catch (exception: Exception) {
                // error during request
                Log.e("error", exception.toString())
            }
        }
    }

    inline fun <reified ClassType> HttpException.getErrorResponse(): ClassType? {
        return this.response()?.errorBody()?.string()?.let {
            Json.decodeFromString(it)
        }
    }
}