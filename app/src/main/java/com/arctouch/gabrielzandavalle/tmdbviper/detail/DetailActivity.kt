package com.arctouch.gabrielzandavalle.tmdbviper.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.arctouch.gabrielzandavalle.tmdbviper.R
import com.arctouch.gabrielzandavalle.tmdbviper.di.TmdbApplication
import com.arctouch.gabrielzandavalle.tmdbviper.model.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

class DetailActivity : AppCompatActivity(), DetailContracts.DetailPresenterOutput, View.OnClickListener {

    companion object {
        const val EXTRA_SELECTED_MOVIE_ID = "com.arctouch.gabrielzandavalle.tmdbviper.detail.SelectedMovieId"
    }

    @Inject
    lateinit var detailPresenterInput: DetailContracts.DetailPresenterInput

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        initConfiguration()

        //setView
        detailPresenterInput.setPresenterOutput(this)

        val movieId: String = intent.extras.get(EXTRA_SELECTED_MOVIE_ID) as String
        detailPresenterInput.viewLoaded(movieId)

        addToWatchList.setOnClickListener(this)
    }

    private fun initConfiguration() {
        TmdbApplication.getComponent(this)
                .plus(DetailModule())
                .inject(this)
    }

    override fun showMovieDetail(movie: Movie) {
        movieName.text = movie.title
        detailOverview.text = movie.overview
        releaseDate.text = movie.releaseDate
        Picasso.with(this).load("https://image.tmdb.org/t/p/w500" + movie.posterPath)
                .into(posterPath)
    }

    override fun onClick(view: View?) {
        detailPresenterInput.addToWatchList()
    }

    override fun showMessageMovieAddedToWatchList(movie: Movie) {
        Toast.makeText(this, movie.title + " Added to watch list.", Toast.LENGTH_LONG).show()
    }

    override fun showMessageFailToAddToWatchList(movie: Movie) {
        Toast.makeText(this, String.format("Failed to add %s to watch list.", movie.title), Toast
                .LENGTH_LONG).show()
    }
}
