package com.arctouch.gabrielzandavalle.tmdbviper.detail

import com.arctouch.gabrielzandavalle.tmdbviper.model.Movie

/**
 * Created by gabrielzandavalle on 3/6/17.
 */
interface DetailPresenterOutput {
  fun showMessageMovieAddedToWatchList(movie: Movie)
  fun showMovieDetail(movie: Movie)
  fun showMessageFailToAddToWatchList(movie: Movie)
}