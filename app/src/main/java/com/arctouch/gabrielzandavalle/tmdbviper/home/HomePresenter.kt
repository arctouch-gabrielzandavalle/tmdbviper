package com.arctouch.gabrielzandavalle.tmdbviper.home

import com.arctouch.gabrielzandavalle.tmdbviper.detail.DetailRouter
import com.arctouch.gabrielzandavalle.tmdbviper.model.Movie

/**
 * Created by gabrielzandavalle on 1/24/17.
 */

class HomePresenter(val homeInteractorInput: HomeContracts.HomeInteractorInput) : HomeContracts.HomePresenterInput, HomeContracts.HomeInteractorOutput {

  lateinit var homePresenterOutput: HomeContracts.HomePresenterOutput

  // HomePresenterInput

  override fun viewLoaded() {
    homeInteractorInput.loadMovies()
  }

  override fun itemClicked(id: String) {
    DetailRouter.createDetailModule(id)
  }

  override fun setPresenterOutput(homePresenterOutput: HomeContracts.HomePresenterOutput) {
    this.homePresenterOutput = homePresenterOutput
  }

  // HomeInteractorOutput

  override fun moviesLoaded(items: List<Movie>) = homePresenterOutput.showMovies(items)
}