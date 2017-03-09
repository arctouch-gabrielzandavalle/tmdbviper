package com.arctouch.gabrielzandavalle.tmdbviper.detail

/**
 * Created by gabrielzandavalle on 3/6/17.
 */
interface DetailPresenterInput {
  fun viewLoaded(id: String)
  fun addToWatchList()
  fun setPresenterOutput(detailPresenterOutput: DetailPresenterOutput)
}
