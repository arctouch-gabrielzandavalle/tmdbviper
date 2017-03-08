package com.arctouch.gabrielzandavalle.tmdbviper.detail

import com.arctouch.gabrielzandavalle.tmdbviper.model.Movie

/**
 * Created by gabrielzandavalle on 3/6/17.
 */
interface DetailInteractorOutput {
  fun addedToWatchList(movie: Movie)
  fun failToAddToWatchList(movie: Movie)
  fun foundSelectedMovie(response: Movie)
}