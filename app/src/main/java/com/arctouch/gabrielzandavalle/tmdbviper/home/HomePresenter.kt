package com.arctouch.gabrielzandavalle.tmdbviper.home

import com.arctouch.gabrielzandavalle.tmdbviper.model.Movie

/**
 * Created by gabrielzandavalle on 1/24/17.
 */

class HomePresenter(val homeInteractorInput: HomeInteractorInput) : HomePresenterInput, HomeInteractorOutput {

  lateinit var homePresenterOutput: HomePresenterOutput

  // HomePresenterInput

  override fun viewLoaded() {
    homeInteractorInput.loadMovies()
  }

  override fun setPresenterOutput(homePresenterOutput: HomePresenterOutput) {
    this.homePresenterOutput = homePresenterOutput
  }

  // HomeInteractorOutput

  override fun moviesLoaded(items: List<Movie>) = homePresenterOutput.showMovies(items)
}