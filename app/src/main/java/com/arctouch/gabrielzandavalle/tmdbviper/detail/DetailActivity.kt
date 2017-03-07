package com.arctouch.gabrielzandavalle.tmdbviper.detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.arctouch.gabrielzandavalle.tmdb.model.Movie
import com.arctouch.gabrielzandavalle.tmdb.service.TmdbApiInterface
import com.arctouch.gabrielzandavalle.tmdbviper.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.addToWatchList
import kotlinx.android.synthetic.main.activity_detail.detailOverview
import kotlinx.android.synthetic.main.activity_detail.movieName
import kotlinx.android.synthetic.main.activity_detail.posterPath
import kotlinx.android.synthetic.main.activity_detail.releaseDate
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.schedulers.Schedulers

class DetailActivity: AppCompatActivity(), DetailPresenterOutput, View.OnClickListener{

  lateinit var detailPresenterInput: DetailPresenterInput

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_detail)

    val rxAdapter = RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io())

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(rxAdapter)
        .build();

    val tmdbApi = retrofit.create(TmdbApiInterface::class.java)

    createModule(tmdbApi)

    val movieId: String = intent.extras.get("selectedMovie") as String
    detailPresenterInput.viewLoaded(movieId)

    addToWatchList.setOnClickListener(this@DetailActivity)
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

  private fun createModule(tmdbApi: TmdbApiInterface) {
    val detailInteractor = DetailInteractor(TmdbRepository(), tmdbApi)

    val detailPresenter = DetailPresenter(detailInteractor)
    detailInteractor.setInteractorOutput(detailPresenter)

    this.detailPresenterInput = detailPresenter
    detailPresenterInput.setPresenterOutput(this@DetailActivity)
  }
}
