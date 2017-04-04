package com.arctouch.gabrielzandavalle.tmdbviper.home

import com.arctouch.gabrielzandavalle.tmdbviper.model.Movie

/**
 * Created by gabrielzandavalle on 3/29/17.
 */
class HomeContracts {

  interface HomeInteractorInput {
    fun loadMovies()
    fun setInteractorOutput(homeInteractorOutput: HomeInteractorOutput)
  }

  interface HomeInteractorOutput {
    fun moviesLoaded(items: List<Movie>)
  }

  interface HomePresenterInput {
    fun viewLoaded()
    fun setPresenterOutput(homePresenterOutput: HomePresenterOutput)
  }

  interface HomePresenterOutput {
    fun showMovies(items: List<Movie>)
  }
}