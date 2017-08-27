package com.arctouch.gabrielzandavalle.tmdbviper.detail

import com.arctouch.gabrielzandavalle.tmdbviper.model.Movie

class DetailPresenter(val detailInteractorInput: DetailContracts.DetailInteractorInput) : DetailContracts.DetailPresenterInput, DetailContracts.DetailInteractorOutput {

    override fun viewLoaded(id: String) {
        detailInteractorInput.findSelectedMovie(id)
    }

    lateinit var detailPresenterOutput: DetailContracts.DetailPresenterOutput

    override fun addToWatchList() {
        detailInteractorInput.addToWatchlist()
    }

    override fun setPresenterOutput(detailPresenterOutput: DetailContracts.DetailPresenterOutput) {
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
