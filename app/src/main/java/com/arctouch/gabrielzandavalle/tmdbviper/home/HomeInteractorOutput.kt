package com.arctouch.gabrielzandavalle.tmdbviper.home

import com.arctouch.gabrielzandavalle.tmdb.model.Movie

/**
 * Created by gabrielzandavalle on 3/2/17.
 */
interface HomeInteractorOutput {

  fun moviesLoaded(items: List<Movie>)
}