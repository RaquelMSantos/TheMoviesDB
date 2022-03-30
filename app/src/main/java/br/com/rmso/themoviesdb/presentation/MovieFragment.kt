package br.com.rmso.themoviesdb.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import br.com.rmso.themoviesdb.databinding.FragmentMovieBinding
import br.com.rmso.themoviesdb.presentation.adapter.MovieAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieFragment : Fragment() {

    private val viewModel by viewModel<MovieViewModel>()
    private val movieAdapter by lazy { MovieAdapter() }
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
        setupObservers()
    }

    private fun setupRecyclerView() {
        with(binding.moviesRecyclerView) {
            adapter = movieAdapter
            layoutManager = GridLayoutManager(context, 2)
        }
    }

    private fun setupObservers() {
        viewModel.movies.observe(viewLifecycleOwner) { movies ->
            movieAdapter.submitList(movies)
        }

        viewModel.viewState.observe(viewLifecycleOwner) { state ->
            setViewState(state)
        }
    }

    private fun setViewState(state: Result<Boolean>) {
          /*when(state) {
              ViewState.LOADING -> showLoading()
              ViewState.SUCCESS -> showContent()
              ViewState.ERROR -> showError()
          } */
    }
}