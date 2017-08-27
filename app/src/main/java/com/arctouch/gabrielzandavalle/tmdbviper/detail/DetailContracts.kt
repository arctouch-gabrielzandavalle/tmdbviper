package com.arctouch.gabrielzandavalle.tmdbviper.detail

import com.arctouch.gabrielzandavalle.tmdbviper.model.Movie

class DetailContracts {

    interface DetailInteractorInput {
        fun addToWatchlist()
        fun findSelectedMovie(id: String)
        fun setInteractorOutput(detailInteractorOutput: DetailInteractorOutput)
    }

    interface DetailInteractorOutput {
        fun addedToWatchList(movie: Movie)
        fun failToAddToWatchList(movie: Movie)
        fun foundSelectedMovie(response: Movie)
    }

    interface DetailPresenterInput {
        fun viewLoaded(id: String)
        fun addToWatchList()
        fun setPresenterOutput(detailPresenterOutput: DetailPresenterOutput)
    }

    interface DetailPresenterOutput {
        fun showMessageMovieAddedToWatchList(movie: Movie)
        fun showMovieDetail(movie: Movie)
        fun showMessageFailToAddToWatchList(movie: Movie)
    }
}
