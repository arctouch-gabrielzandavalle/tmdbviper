package com.arctouch.gabrielzandavalle.tmdbviper.detail

import com.arctouch.gabrielzandavalle.tmdbviper.TmdbRepository
import com.arctouch.gabrielzandavalle.tmdbviper.di.ActivityScope
import com.arctouch.gabrielzandavalle.tmdbviper.service.TmdbApiInterface
import dagger.Module
import dagger.Provides

/**
 * Created by gabrielzandavalle on 3/8/17.
 */
@Module
class DetailModule {

  @Provides @ActivityScope fun provideDetailInteractor(tmdbRepository: TmdbRepository, tmdbApiInterface:
  TmdbApiInterface) : DetailInteractorInput {
    return DetailInteractor(tmdbRepository, tmdbApiInterface)
  }

  @Provides @ActivityScope
  fun provideDetailPresenterInput(detailInteractorInput : DetailInteractorInput) : DetailPresenterInput {
    val detailPresenter = DetailPresenter(detailInteractorInput)
    detailInteractorInput.setInteractorOutput(detailPresenter)
    return detailPresenter
  }
}