package com.arctouch.gabrielzandavalle.tmdbviper.detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.arctouch.gabrielzandavalle.tmdbviper.model.Movie
import com.arctouch.gabrielzandavalle.tmdbviper.R
import com.arctouch.gabrielzandavalle.tmdbviper.di.TmdbApplication
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.addToWatchList
import kotlinx.android.synthetic.main.activity_detail.detailOverview
import kotlinx.android.synthetic.main.activity_detail.movieName
import kotlinx.android.synthetic.main.activity_detail.posterPath
import kotlinx.android.synthetic.main.activity_detail.releaseDate
import javax.inject.Inject

class DetailActivity: AppCompatActivity(), DetailPresenterOutput, View.OnClickListener{

  @Inject
  lateinit var detailPresenterInput: DetailPresenterInput

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_detail)

    initConfiguration()

    //setView
    detailPresenterInput.setPresenterOutput(this)

    val movieId: String = intent.extras.get("selectedMovie") as String
    detailPresenterInput.viewLoaded(movieId)

    addToWatchList.setOnClickListener(this)
  }

  private fun initConfiguration() {
    TmdbApplication.get(this)
        .applicationComponent
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
    Toast.makeText(this, movie.title + " Added to watch list.",  Toast.LENGTH_LONG).show()
  }

  override fun showMessageFailToAddToWatchList(movie: Movie) {
    Toast.makeText(this, String.format("Failed to add %s to watch list.", movie.title),  Toast
        .LENGTH_LONG).show()
  }
}
