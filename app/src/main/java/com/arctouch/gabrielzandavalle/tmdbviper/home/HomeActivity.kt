package com.arctouch.gabrielzandavalle.tmdbviper.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.arctouch.gabrielzandavalle.tmdbviper.R
import com.arctouch.gabrielzandavalle.tmdbviper.adapter.MovieAdapter
import com.arctouch.gabrielzandavalle.tmdbviper.di.TmdbApplication
import com.arctouch.gabrielzandavalle.tmdbviper.model.Movie
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), HomeContracts.HomePresenterOutput {

    @Inject
    lateinit var homePresenterInput: HomeContracts.HomePresenterInput

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        injectDependencies()

        homePresenterInput.viewLoaded()
    }

    private fun injectDependencies() {
        TmdbApplication.getComponent(this)
                .plus(HomeModule(this))
                .inject(this)
    }

    override fun showMovies(items: List<Movie>) {
        moviesRecyclerView.adapter = MovieAdapter(items)
        moviesRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}
