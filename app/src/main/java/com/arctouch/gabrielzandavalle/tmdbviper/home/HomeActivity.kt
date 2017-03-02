package com.arctouch.gabrielzandavalle.tmdbviper.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.arctouch.gabrielzandavalle.tmdb.adapter.MovieAdapter
import com.arctouch.gabrielzandavalle.tmdb.model.Movie
import com.arctouch.gabrielzandavalle.tmdb.service.TmdbApiInterface
import com.arctouch.gabrielzandavalle.tmdbviper.R
import kotlinx.android.synthetic.main.activity_home.moviesRecyclerView
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.schedulers.Schedulers

class HomeActivity: AppCompatActivity(), HomePresenterOutput{

  lateinit var homePresenterInput: HomePresenterInput

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home)

    val rxAdapter = RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io())

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(rxAdapter)
        .build();

    val tmdbApi = retrofit.create(TmdbApiInterface::class.java)

    val homeInteractor = HomeInteractor(tmdbApi)

    val homePresenter = HomePresenter(homeInteractor)
    homeInteractor.setInteractorOutput(homePresenter)

    this.homePresenterInput = homePresenter
    homePresenterInput.setPresenterOutput(this@HomeActivity)

    homePresenterInput.viewLoaded()
  }

  // HomePresenterOutput

  override fun showMovies(items: List<Movie>) {
    moviesRecyclerView.adapter = MovieAdapter(items)
    moviesRecyclerView.layoutManager = LinearLayoutManager(this@HomeActivity)
  }
}
