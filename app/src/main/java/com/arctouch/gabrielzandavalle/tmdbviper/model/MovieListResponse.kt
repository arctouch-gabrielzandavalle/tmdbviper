package com.arctouch.gabrielzandavalle.tmdb.model

import org.jetbrains.annotations.Mutable

/**
 * Created by gabrielzandavalle on 1/18/17.
 */
class MovieListResponse(
  val id: String = "",
  val items: List<Movie> = mutableListOf()
)