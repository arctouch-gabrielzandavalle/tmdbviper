package com.arctouch.gabrielzandavalle.tmdbviper.detail

import com.arctouch.gabrielzandavalle.tmdbviper.TmdbRepository
import com.arctouch.gabrielzandavalle.tmdbviper.di.ActivityScope
import com.arctouch.gabrielzandavalle.tmdbviper.service.TmdbApiInterface
import dagger.Module
import dagger.Provides

@Module
class DetailModule {

    @Provides
    @ActivityScope
    fun provideDetailInteractor(tmdbRepository: TmdbRepository, tmdbApiInterface:
    TmdbApiInterface): DetailContracts.DetailInteractorInput {
        return DetailInteractor(tmdbRepository, tmdbApiInterface)
    }

    @Provides
    @ActivityScope
    fun provideDetailPresenterInput(detailInteractorInput: DetailContracts.DetailInteractorInput): DetailContracts.DetailPresenterInput {
        val detailPresenter = DetailPresenter(detailInteractorInput)
        detailInteractorInput.setInteractorOutput(detailPresenter)
        return detailPresenter
    }
}
