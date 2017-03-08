package com.arctouch.gabrielzandavalle.tmdbviper.service

import com.arctouch.gabrielzandavalle.tmdbviper.model.Movie
import com.arctouch.gabrielzandavalle.tmdbviper.model.MovieListDisplayModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable

/**
 * Created by gabrielzandavalle on 1/18/17.
 */

interface TmdbApiInterface {

  @GET("list/{id}")
  fun getList(@Path("id") id: String, @Query("api_key") apiKey: String ) :
      Observable<MovieListDisplayModel>

  @GET("movie/{id}")
  fun  getMovie(@Path("id") id: String, @Query("api_key") apiKey: String ): Observable<Movie>

  fun getInts() : Observable<Int>{
    return Observable.just(1, 2, 3 )
  }
}
