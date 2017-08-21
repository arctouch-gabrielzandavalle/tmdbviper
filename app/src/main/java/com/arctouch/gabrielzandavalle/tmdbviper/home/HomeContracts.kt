package com.arctouch.gabrielzandavalle.tmdbviper.home

import com.arctouch.gabrielzandavalle.tmdbviper.model.Movie

class HomeContracts {

    interface HomePresenterInput {
        fun viewLoaded()
    }

    interface HomeInteractorInput {
        fun loadMovies()
        fun setInteractorOutput(homeInteractorOutput: HomeInteractorOutput)
    }

    interface HomeInteractorOutput {
        fun moviesLoaded(items: List<Movie>)
    }

    interface HomePresenterOutput {
        fun showMovies(items: List<Movie>)
    }
}
