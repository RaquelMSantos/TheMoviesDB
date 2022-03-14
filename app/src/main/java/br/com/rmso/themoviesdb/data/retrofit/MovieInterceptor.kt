package br.com.rmso.themoviesdb.data.retrofit

import br.com.rmso.themoviesdb.BuildConfig
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response
import java.util.concurrent.TimeUnit

const val CACHE_CONTROL_HEADER = "Cache-Control"
const val MAX_AGE = 10
const val TEXT_API_KEY = "api_key"

class MovieInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val newUrl = request.url.newBuilder()
            .addQueryParameter(TEXT_API_KEY, BuildConfig.tmdbToken)
            .build()

        val cacheControl = CacheControl.Builder()
            .maxAge(MAX_AGE, TimeUnit.MINUTES)
            .build()

        val newRequest = chain.request()
            .newBuilder()
            .url(newUrl)
            .build()

        return chain.proceed(newRequest)
            .newBuilder()
            .header(CACHE_CONTROL_HEADER, cacheControl.toString())
            .build()
    }
}
