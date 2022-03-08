package br.com.rmso.themoviesdb.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import br.com.rmso.themoviesdb.R
import br.com.rmso.themoviesdb.databinding.ListItemMovieBinding
import br.com.rmso.themoviesdb.presentation.model.Movie
import com.bumptech.glide.Glide

private const val basePosterUrl = "https://image.tmdb.org/t/p/w500/"

internal class MoviesViewHolder(private val listItemMovieBinding: ListItemMovieBinding) :
    RecyclerView.ViewHolder(listItemMovieBinding.root) {

    fun bind(movie: Movie, context: Context) {
        listItemMovieBinding.titleTextView.text = movie.title
        Glide
            .with(context)
            .load(basePosterUrl + movie.posterPath)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(listItemMovieBinding.postImageView)
    }

    companion object {
        fun from(parent: ViewGroup): ViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ListItemMovieBinding.inflate(layoutInflater, parent, false)
            return MoviesViewHolder(binding)
        }
    }
}
