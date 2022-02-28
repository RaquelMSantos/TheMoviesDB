package br.com.rmso.themoviesdb.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import br.com.rmso.themoviesdb.R
import br.com.rmso.themoviesdb.presentation.model.Movie
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieFragment : Fragment() {

    private val viewModel by viewModel<MovieViewModel>()

    companion object {
        fun newInstance() = MovieFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObserver()
    }

    private fun setupObserver() {
        viewModel.movies.observe(viewLifecycleOwner, Observer {
            setViewState(it)
        })
    }

    private fun setViewState(list: List<Movie>) {
        when(list) {
            MyViewState.LOADING -> showLoading()
            MyViewState.SUCCESS -> showContent(list)
            MyViewState.ERROR -> showError()
        }
    }

    private fun showLoading() {
        TODO("Not yet implemented")
    }

    private fun showContent(list: List<Movie>) {
        TODO("Not yet implemented")
    }

    private fun showError() {
        TODO("Not yet implemented")
    }
}