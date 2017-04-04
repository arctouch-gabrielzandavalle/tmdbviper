package com.arctouch.gabrielzandavalle.tmdbviper.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.arctouch.gabrielzandavalle.tmdbviper.adapter.MovieAdapter
import com.arctouch.gabrielzandavalle.tmdbviper.model.Movie
import com.arctouch.gabrielzandavalle.tmdbviper.service.TmdbApiInterface
import com.arctouch.gabrielzandavalle.tmdbviper.R
import com.arctouch.gabrielzandavalle.tmdbviper.detail.DetailRouter
import com.arctouch.gabrielzandavalle.tmdbviper.di.TmdbApplication
import kotlinx.android.synthetic.main.activity_home.moviesRecyclerView
import javax.inject.Inject

class HomeActivity: AppCompatActivity(), HomeContracts.HomePresenterOutput {

  @Inject
  lateinit var homePresenterInput: HomeContracts.HomePresenterInput

  @Inject
  lateinit var tmdbApi: TmdbApiInterface

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home)

    DetailRouter.setActivity(this)

    initConfiguration()

    homePresenterInput.setPresenterOutput(this)
    homePresenterInput.viewLoaded()
  }

  private fun initConfiguration() {
    TmdbApplication.get(this)
        .applicationComponent
        .plus(HomeModule())
        .inject(this)
  }

  // HomePresenterOutput

  override fun showMovies(items: List<Movie>) {
    moviesRecyclerView.adapter = MovieAdapter(items)
    moviesRecyclerView.layoutManager = LinearLayoutManager(this)
  }
}
