package com.arctouch.gabrielzandavalle.tmdbviper.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arctouch.gabrielzandavalle.tmdbviper.R
import com.arctouch.gabrielzandavalle.tmdbviper.di.TmdbApplication
import com.arctouch.gabrielzandavalle.tmdbviper.home.HomeRouter
import com.arctouch.gabrielzandavalle.tmdbviper.model.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_item.view.*
import javax.inject.Inject

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

    class ViewHolder(val context: Context, val view: View) : RecyclerView.ViewHolder(view) {

        @Inject
        lateinit var homeRouter: HomeRouter

        init {
            TmdbApplication.get(context)
                    .applicationComponent
                    .inject(this)
        }

        fun bind(item: Movie) {
            view.movieName.text = item.title
            view.overview.text = item.overview
            Picasso.with(context).load("https://image.tmdb.org/t/p/w500" + item.posterPath).into(view.posterPath)

            view.setOnClickListener {
                homeRouter.navigateToDetail(item.id)
            }
        }
    }
}
