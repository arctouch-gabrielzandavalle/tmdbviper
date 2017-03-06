package com.arctouch.gabrielzandavalle.tmdbviper.detail

import com.arctouch.gabrielzandavalle.tmdb.model.Movie

/**
 * Created by gabrielzandavalle on 3/6/17.
 */
interface DetailInteractorInput {
  fun addToWatchlist(movie: Movie)
  fun findSelectedMovie(id: String)
  fun setInteractorOutput(detailInteractorOutput: DetailInteractorOutput)

}