package com.arctouch.gabrielzandavalle.tmdbviper.detail

import android.util.Log
import com.arctouch.gabrielzandavalle.tmdbviper.TmdbRepository
import com.arctouch.gabrielzandavalle.tmdbviper.model.Movie
import com.arctouch.gabrielzandavalle.tmdbviper.service.TmdbApiInterface
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class DetailInteractor(
        private val tmdbRepository: TmdbRepository,
        private val tmdbApiInterface: TmdbApiInterface,
        private val subscribeOn: Scheduler = Schedulers.io(),
        private val observeOn: Scheduler = AndroidSchedulers.mainThread())
    : DetailContracts.DetailInteractorInput {

    private companion object {
        val TAG: String = DetailInteractor::class.java.name
    }

    lateinit var movie: Movie

    override fun findSelectedMovie(id: String) {
        tmdbApiInterface.getMovie(id, "1f54bd990f1cdfb230adb312546d765d")
                .subscribeOn(subscribeOn)
                .observeOn(observeOn)
                .subscribe({
                    movie = it
                    detailInteractorOutput.foundSelectedMovie(movie)
                }, {
                    Log.e(TAG, it.message, it)
                })
    }

    lateinit var detailInteractorOutput: DetailContracts.DetailInteractorOutput

    override fun addToWatchlist() {
        if (tmdbRepository.addToWatchList(this.movie)) {
            detailInteractorOutput.addedToWatchList(movie)
        } else {
            detailInteractorOutput.failToAddToWatchList(movie)
        }
    }

    override fun setInteractorOutput(detailInteractorOutput: DetailContracts.DetailInteractorOutput) {
        this.detailInteractorOutput = detailInteractorOutput
    }
}
