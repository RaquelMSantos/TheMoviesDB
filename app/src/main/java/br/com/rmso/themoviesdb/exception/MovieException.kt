package br.com.rmso.themoviesdb.exception

internal class MovieException(override val cause: Throwable? = null): Exception(cause)