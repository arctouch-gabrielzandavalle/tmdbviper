package com.arctouch.gabrielzandavalle.tmdb.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.arctouch.gabrielzandavalle.tmdb.detail.DetailActivity
import com.arctouch.gabrielzandavalle.tmdb.model.Movie
import com.arctouch.gabrielzandavalle.tmdbviper.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_item.view.movieName
import kotlinx.android.synthetic.main.movie_item.view.overview
import kotlinx.android.synthetic.main.movie_item.view.posterPath

/**
 * Created by gabrielzandavalle on 1/17/17.
 */

open class MovieAdapter(var movies: List<Movie>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val context = parent.context
    val layoutInflater = LayoutInflater.from(context)
    val view = layoutInflater.inflate(R.layout.movie_item, parent, false)

    return ViewHolder(context, view)
  }

  override fun getItemCount(): Int {
    return movies.size
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(movies[position])
  }

  class ViewHolder(val context: Context, val view : View) : RecyclerView.ViewHolder(view) {
    val posterPath: ImageView = view.posterPath
    val movieName: TextView = view.movieName
    val overview: TextView = view.overview

    fun bind(item: Movie) {
      movieName.text = item.title
      overview.text = item.overview
      Picasso.with(context).load("https://image.tmdb.org/t/p/w500" + item.posterPath).into(posterPath)

      view.setOnClickListener {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("selectedMovie", item.id)
        context.startActivity(intent)
      }
    }
  }
}
