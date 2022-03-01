package br.com.rmso.themoviesdb.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import br.com.rmso.themoviesdb.databinding.ListItemMovieBinding
import br.com.rmso.themoviesdb.presentation.model.Movie
import coil.load

private const val basePosterUrl = "https://image.tmdb.org/t/p/w500/"

internal class MoviesViewHolder(private val listItemMovieBinding: ListItemMovieBinding) :
    RecyclerView.ViewHolder(listItemMovieBinding.root) {

    fun bind(movie: Movie) {
        with(listItemMovieBinding) {
            titleTextView.text = movie.title
            postImageView.load(basePosterUrl + movie.posterPath)
        }
    }

    companion object {
        fun from(parent: ViewGroup): ViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ListItemMovieBinding.inflate(layoutInflater, parent, false)
            return MoviesViewHolder(binding)
        }
    }
}
