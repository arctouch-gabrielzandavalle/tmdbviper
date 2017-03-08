package com.arctouch.gabrielzandavalle.tmdbviper

import com.arctouch.gabrielzandavalle.tmdbviper.model.Movie

class TmdbRepository {

  val watchList: MutableList<Movie> = mutableListOf()

  fun addToWatchList(movie: Movie) : Boolean{
    return this.watchList.add(movie)
  }
}