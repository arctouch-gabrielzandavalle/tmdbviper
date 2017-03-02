package com.arctouch.gabrielzandavalle.tmdbviper.home

import com.arctouch.gabrielzandavalle.tmdb.model.Movie

/**
 * Created by gabrielzandavalle on 1/24/17.
 */

interface HomeView {
  fun loadMovies(movies: List<Movie>)
}