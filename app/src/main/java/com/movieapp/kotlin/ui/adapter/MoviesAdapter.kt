package com.movieapp.kotlin.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.movieapp.kotlin.R
import com.movieapp.kotlin.domain.model.toprated.SingleMovieModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_list_item.view.*

 class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {
    var mainList : ArrayList<SingleMovieModel> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
       return MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return mainList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(mainList[position])
    }

    fun addItems(moviesResults : List<SingleMovieModel>){
        mainList.addAll(moviesResults)
        notifyItemRangeInserted(mainList.size,moviesResults.size)
    }


     class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind (singleMovieModel: SingleMovieModel) = with(itemView){
            Picasso.get().load("https://image.tmdb.org/t/p/w500".plus(singleMovieModel.posterPath)).into(poster_url)
            movie_name.text = singleMovieModel.title

        }
    }
}