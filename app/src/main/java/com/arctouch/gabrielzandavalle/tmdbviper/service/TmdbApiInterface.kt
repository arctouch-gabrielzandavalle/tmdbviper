package com.arctouch.gabrielzandavalle.tmdbviper.service

import com.arctouch.gabrielzandavalle.tmdbviper.model.Movie
import com.arctouch.gabrielzandavalle.tmdbviper.model.MovieListDisplayModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable

interface TmdbApiInterface {

    @GET("list/{id}")
    fun getList(@Path("id") id: String, @Query("api_key") apiKey: String): Observable<MovieListDisplayModel>

    @GET("movie/{id}")
    fun getMovie(@Path("id") id: String, @Query("api_key") apiKey: String): Observable<Movie>
}
