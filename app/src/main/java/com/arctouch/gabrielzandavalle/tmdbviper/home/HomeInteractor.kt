package com.arctouch.gabrielzandavalle.tmdbviper.home

import android.util.Log
import com.arctouch.gabrielzandavalle.tmdbviper.model.MovieListDisplayModel
import com.arctouch.gabrielzandavalle.tmdbviper.service.TmdbApiInterface
import rx.Observable
import rx.Scheduler
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by gabrielzandavalle on 3/2/17.
 */
class HomeInteractor(val tmdbApi: TmdbApiInterface,val  scheduler: Scheduler = Schedulers.io(),
    val observeOn: Scheduler = AndroidSchedulers.mainThread()) :
    HomeContracts
.HomeInteractorInput {

  val TAG = HomeInteractor::class.java.name

  lateinit var homeInteractorOutput: HomeContracts.HomeInteractorOutput

  override fun setInteractorOutput(homeInteractorOutput: HomeContracts.HomeInteractorOutput) {
    this.homeInteractorOutput = homeInteractorOutput
  }

  override fun loadMovies() {
    val list: Observable<MovieListDisplayModel> = tmdbApi.getList("1", "1f54bd990f1cdfb230adb312546d765d")

    list.subscribeOn(scheduler)
        .observeOn(observeOn)
        .subscribe (object: Subscriber<MovieListDisplayModel>(){
          override fun onCompleted() {
            //Completed
          }

          override fun onError(e: Throwable) {
            Log.d(TAG, e.message)
          }

          override fun onNext(response: MovieListDisplayModel?) {
            Log.e("Output",response.toString());

            homeInteractorOutput.moviesLoaded(response?.items!!)
          }
        })
  }
}