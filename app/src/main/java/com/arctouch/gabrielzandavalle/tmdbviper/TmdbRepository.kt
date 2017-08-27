package com.arctouch.gabrielzandavalle.tmdbviper

import com.arctouch.gabrielzandavalle.tmdbviper.model.Movie

class TmdbRepository {

    private val watchList = mutableListOf<Movie>()

    fun addToWatchList(movie: Movie) = watchList.add(movie)
}
