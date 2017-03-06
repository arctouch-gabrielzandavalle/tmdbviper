package com.arctouch.gabrielzandavalle.tmdbviper.detail

import android.util.Log
import com.arctouch.gabrielzandavalle.tmdb.model.Movie
import com.arctouch.gabrielzandavalle.tmdb.service.TmdbApiInterface
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by gabrielzandavalle on 3/6/17.
 */
class DetailInteractor(val tmdbRepository: TmdbRepository, val tmdbApiInterface: TmdbApiInterface) : DetailInteractorInput{

  val TAG = DetailInteractor::class.java.name

  override fun findSelectedMovie(id: String) {
    tmdbApiInterface.getMovie(id, "1f54bd990f1cdfb230adb312546d765d").subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe (object: Subscriber<Movie>(){
          override fun onCompleted() {
            //Completed
          }

          override fun onError(e: Throwable) {
            Log.d(TAG, e.message)

            detailInteractorOutput.failToAddToWatchList()
          }

          override fun onNext(response: Movie?) {
            Log.e("Output",response.toString());

            if (response != null) {
              detailInteractorOutput.foundSelectedMovie(response)
            }
          }
        })
  }

  lateinit var detailInteractorOutput: DetailInteractorOutput

  override fun addToWatchlist(movie: Movie){
    if (tmdbRepository.addToWatchList(movie)) {
      detailInteractorOutput.addedToWatchList(movie)
    }else{
      detailInteractorOutput.failToAddToWatchList()
    }
  }

  override fun setInteractorOutput(detailInteractorOutput: DetailInteractorOutput) {
    this.detailInteractorOutput = detailInteractorOutput
  }
}

class TmdbRepository {

  val watchList: MutableList<Movie> = mutableListOf()

  fun addToWatchList(movie: Movie) : Boolean{
    return this.watchList.add(movie)
  }
}
