package com.arctouch.gabrielzandavalle.tmdbviper.home

import com.arctouch.gabrielzandavalle.tmdbviper.detail.DetailRouter
import com.arctouch.gabrielzandavalle.tmdbviper.model.Movie

class HomePresenter(
        private val homePresenterOutput: HomeContracts.HomePresenterOutput,
        private val homeInteractorInput: HomeContracts.HomeInteractorInput)
    : HomeContracts.HomePresenterInput, HomeContracts.HomeInteractorOutput {

    override fun viewLoaded() {
        homeInteractorInput.loadMovies()
    }

    override fun moviesLoaded(items: List<Movie>) = homePresenterOutput.showMovies(items)
}
