package com.arctouch.gabrielzandavalle.tmdbviper.detail

import com.arctouch.gabrielzandavalle.tmdb.model.Movie

/**
 * Created by gabrielzandavalle on 3/6/17.
 */
interface DetailPresenterInput {
  fun viewLoaded(id: String)
  fun addToWatchList()
  fun setPresenterOutput(detailPresenterOutput: DetailPresenterOutput)
}
