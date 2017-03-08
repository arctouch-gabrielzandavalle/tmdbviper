package com.arctouch.gabrielzandavalle.tmdbviper.detail

import com.arctouch.gabrielzandavalle.tmdbviper.model.Movie

/**
 * Created by gabrielzandavalle on 3/6/17.
 */
interface DetailInteractorInput {
  fun addToWatchlist()
  fun findSelectedMovie(id: String)
  fun setInteractorOutput(detailInteractorOutput: DetailInteractorOutput)

}