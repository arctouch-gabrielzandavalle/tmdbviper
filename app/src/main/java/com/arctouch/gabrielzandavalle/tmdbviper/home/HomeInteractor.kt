package com.arctouch.gabrielzandavalle.tmdbviper.home

import android.util.Log
import com.arctouch.gabrielzandavalle.tmdbviper.service.TmdbApiInterface
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class HomeInteractor(private val tmdbApi: TmdbApiInterface,
                     private val subscribeOn: Scheduler = Schedulers.io(),
                     private val observeOn: Scheduler = AndroidSchedulers.mainThread()) :
        HomeContracts.HomeInteractorInput {

    private companion object {
        val TAG: String = HomeInteractor::class.java.name
    }

    lateinit var homeInteractorOutput: HomeContracts.HomeInteractorOutput

    override fun setInteractorOutput(homeInteractorOutput: HomeContracts.HomeInteractorOutput) {
        this.homeInteractorOutput = homeInteractorOutput
    }

    override fun loadMovies() {
        val list = tmdbApi.getList("1", "1f54bd990f1cdfb230adb312546d765d")

        list.subscribeOn(subscribeOn)
                .observeOn(observeOn)
                .subscribe({
                    homeInteractorOutput.moviesLoaded(it.items)
                }, {
                    Log.e(TAG, it.message, it)
                })
    }
}
