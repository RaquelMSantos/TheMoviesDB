package br.com.rmso.themoviesdb.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import br.com.rmso.themoviesdb.presentation.model.Movie

internal class MovieAdapter: ListAdapter<Movie, MoviesViewHolder>(MovieDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        return MoviesViewHolder.from(parent) as MoviesViewHolder
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

}