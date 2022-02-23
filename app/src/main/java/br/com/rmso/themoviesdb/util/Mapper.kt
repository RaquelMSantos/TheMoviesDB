package br.com.rmso.themoviesdb.util

interface Mapper<S, T> {
    fun map(source: S): T
}