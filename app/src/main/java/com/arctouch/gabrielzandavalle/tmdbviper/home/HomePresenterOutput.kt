package com.arctouch.gabrielzandavalle.tmdbviper.home

import com.arctouch.gabrielzandavalle.tmdbviper.model.Movie

/**
 * Created by gabrielzandavalle on 3/2/17.
 */
interface HomePresenterOutput {
  fun showMovies(items: List<Movie>)
}