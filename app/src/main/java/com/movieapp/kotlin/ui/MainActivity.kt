package com.movieapp.kotlin.ui

import android.graphics.Movie
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.movieapp.kotlin.R
import com.movieapp.kotlin.presentation.viewmodels.GetAllMoviesViewModel
import com.movieapp.kotlin.ui.adapter.MoviesAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val getAllMoviesViewModel : GetAllMoviesViewModel by viewModel()
    private lateinit var adapter: MoviesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecyclerView()
        getAllMoviesViewModel.loadAllMovies()
    }

    override fun onStart() {
        super.onStart()
        observeLoading()
        observeMovies()
    }

    private fun observeMovies(){
        getAllMoviesViewModel.getMovies().observe(this, Observer { it?.let {
            Log.d("Movies" , "Size "+ it.results.size)
            adapter.addItems(it.results)
        } })
    }

    private fun observeLoading(){
        getAllMoviesViewModel.isDataLoaded().observe(this, Observer { it?.let {
                if (it) progressBar.visibility = View.GONE else progressBar.visibility = View.VISIBLE
            }
        })
    }

    private fun setUpRecyclerView(){
        adapter = MoviesAdapter()
        movies_recyclerView.layoutManager = GridLayoutManager(this,2)
        movies_recyclerView.adapter = adapter
    }
}
