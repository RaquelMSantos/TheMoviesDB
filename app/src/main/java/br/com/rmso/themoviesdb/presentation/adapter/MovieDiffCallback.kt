package br.com.rmso.themoviesdb.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import br.com.rmso.themoviesdb.presentation.model.Movie

internal class MovieDiffCallback: DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean =
        newItem.id == oldItem.id

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean =
        newItem == oldItem
}