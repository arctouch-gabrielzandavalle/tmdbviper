package com.arctouch.gabrielzandavalle.tmdbviper.home

/**
 * Created by gabrielzandavalle on 3/2/17.
 */
interface HomeInteractorInput {

  fun loadMovies()
  fun setInteractorOutput(homeInteractorOutput: HomeInteractorOutput)
}