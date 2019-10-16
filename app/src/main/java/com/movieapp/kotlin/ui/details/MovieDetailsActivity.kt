package com.movieapp.kotlin.ui.details

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.movieapp.kotlin.R
import com.movieapp.kotlin.domain.model.details.Genres
import com.movieapp.kotlin.presentation.viewmodels.MovieDetailsViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.progressBar
import kotlinx.android.synthetic.main.activity_movie_details.*
import kotlinx.android.synthetic.main.movie_list_item.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailsActivity : AppCompatActivity() {
    private val movieDetailsViewModel: MovieDetailsViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        val bundle: Bundle = requireNotNull(intent?.extras)
        val id: Int = bundle!!.getInt("id")
        val title: String = bundle.getString("title","")



        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = title

        movieDetailsViewModel.requestMovieDetails(id)
        observeLoading()
        observeMovies()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home){
            finish()
        }
        return true
    }

    private fun observeMovies() {
        movieDetailsViewModel.getMovieDetails().observe(this, Observer {
            it?.let {
                Picasso.get().load("https://image.tmdb.org/t/p/w500".plus(it.poster_path))
                    .into(poster_details)

                vote_value.text = it.vote_average.toString()
                movie_vote_count_value.text = it.vote_count.toString()
                release_date_value.text = it.release_date
                language_value.text = it.original_language
                genre_value.text = getGenre(it.genres)

            }
        })
    }

    private fun observeLoading() {
        movieDetailsViewModel.isDataLoaded().observe(this, Observer {
            it?.let {
                if (it) {
                    details_progressBar.visibility = View.GONE
                    parent_details.visibility = View.VISIBLE
                } else {
                    details_progressBar.visibility = View.VISIBLE
                    parent_details.visibility = View.GONE

                }

            }
        })
    }



    private fun getGenre(genres: List<Genres>): String {
        val genreList = arrayListOf<String>()
        for (currentGenre in genres) {
            genreList.add(currentGenre.name)
        }
        return genreList.joinToString()
    }

}