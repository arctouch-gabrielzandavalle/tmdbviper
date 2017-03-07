package com.arctouch.gabrielzandavalle.tmdbviper.detail

import com.arctouch.gabrielzandavalle.tmdb.model.Movie

/**
 * Created by gabrielzandavalle on 3/2/17.
 */
class DetailPresenter(val detailInteractorInput: DetailInteractorInput) : DetailPresenterInput, DetailInteractorOutput{

  override fun viewLoaded(id: String) {
    detailInteractorInput.findSelectedMovie(id)
  }

  lateinit var detailPresenterOutput: DetailPresenterOutput

  override fun addToWatchList() {
    detailInteractorInput.addToWatchlist()
  }

  override fun setPresenterOutput(detailPresenterOutput: DetailPresenterOutput) {
    this.detailPresenterOutput = detailPresenterOutput
  }

  //DetailInteractorOutput

  override fun foundSelectedMovie(movie: Movie) {
    detailPresenterOutput.showMovieDetail(movie)
  }

  override fun addedToWatchList(movie: Movie) {
    detailPresenterOutput.showMessageMovieAddedToWatchList(movie)
  }

  override fun failToAddToWatchList(movie: Movie) {
    detailPresenterOutput.showMessageFailToAddToWatchList(movie)
  }
}