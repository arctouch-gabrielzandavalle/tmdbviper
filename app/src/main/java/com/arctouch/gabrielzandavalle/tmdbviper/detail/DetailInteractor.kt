package com.arctouch.gabrielzandavalle.tmdbviper.detail

import android.util.Log
import com.arctouch.gabrielzandavalle.tmdbviper.TmdbRepository
import com.arctouch.gabrielzandavalle.tmdbviper.model.Movie
import com.arctouch.gabrielzandavalle.tmdbviper.service.TmdbApiInterface
import rx.Scheduler
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by gabrielzandavalle on 3/6/17.
 */
class DetailInteractor(val tmdbRepository: TmdbRepository, val tmdbApiInterface:
TmdbApiInterface, val subscribeOn: Scheduler = Schedulers.io(), val observeOn: Scheduler =
AndroidSchedulers.mainThread()) : DetailContracts.DetailInteractorInput {

  val TAG = DetailInteractor::class.java.name

  lateinit var movie: Movie

  override fun findSelectedMovie(id: String) {
    tmdbApiInterface.getMovie(id, "1f54bd990f1cdfb230adb312546d765d")
        .subscribeOn(subscribeOn)
        .observeOn(observeOn)
        .subscribe (object: Subscriber<Movie>(){
          override fun onCompleted() {
            //Completed
          }

          override fun onError(e: Throwable) {
            Log.d(TAG, e.message)
          }

          override fun onNext(movie: Movie?) {
            Log.e("Output",movie?.toString());

            if (movie != null) {
              this@DetailInteractor.movie = movie
              detailInteractorOutput.foundSelectedMovie(movie)
            }
          }
        })
  }

  lateinit var detailInteractorOutput: DetailContracts.DetailInteractorOutput

  override fun addToWatchlist(){
    if (tmdbRepository.addToWatchList(this.movie)) {
      detailInteractorOutput.addedToWatchList(movie)
    }else{
      detailInteractorOutput.failToAddToWatchList(movie)
    }
  }

  override fun setInteractorOutput(detailInteractorOutput: DetailContracts.DetailInteractorOutput) {
    this.detailInteractorOutput = detailInteractorOutput
  }
}
