package br.com.rmso.themoviesdb.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import br.com.rmso.themoviesdb.databinding.FragmentMovieBinding
import br.com.rmso.themoviesdb.presentation.adapter.MovieAdapter
import br.com.rmso.themoviesdb.presentation.model.Movie
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieFragment : Fragment() {

    private val viewModel by viewModel<MovieViewModel>()
    private val adapter: MovieAdapter by inject()
    private lateinit var binding: FragmentMovieBinding

    companion object {
        fun newInstance() = MovieFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObserver()
    }

    private fun setupRecyclerView() {
        binding.moviesRecyclerView.adapter = adapter
    }

    private fun setupObserver() {
        viewModel.movies.observe(viewLifecycleOwner, Observer { movies ->
            adapter.submitList(movies)
        })
    }

    private fun setViewState(list: List<Movie>) {
        TODO("Not yet implemented")
      /*  when(list) {
            State.LOADING -> showLoading()
            State.SUCCESS -> showContent(list)
            State.ERROR -> showError()
        } */
    }
}