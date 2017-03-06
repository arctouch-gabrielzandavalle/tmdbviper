package com.arctouch.gabrielzandavalle.tmdbviper.detail

import com.arctouch.gabrielzandavalle.tmdb.model.Movie

/**
 * Created by gabrielzandavalle on 3/6/17.
 */
interface DetailPresenterOutput {
  fun showMessageMovieAddedToWatchList(movie: Movie)
  fun showMessageFailToAddToWatchList()
  fun showMovieDetail(movie: Movie)
}