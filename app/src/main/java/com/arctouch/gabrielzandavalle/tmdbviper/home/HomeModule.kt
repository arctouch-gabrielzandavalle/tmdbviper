package com.arctouch.gabrielzandavalle.tmdbviper.home

import com.arctouch.gabrielzandavalle.tmdbviper.di.ActivityScope
import com.arctouch.gabrielzandavalle.tmdbviper.service.TmdbApiInterface
import dagger.Module
import dagger.Provides

/**
 * Created by gabrielzandavalle on 3/8/17.
 */
@Module
class HomeModule {

  @Provides @ActivityScope fun provideCarBrandsInteractor(tmdbApiInterface: TmdbApiInterface): HomeInteractorInput {
    return HomeInteractor(tmdbApiInterface)
  }

  @Provides @ActivityScope
  fun provideHomePresenterInput(homeInteractorInput: HomeInteractorInput) : HomePresenterInput {
    val homePresenter: HomePresenter =  HomePresenter(homeInteractorInput)
    homeInteractorInput.setInteractorOutput(homePresenter)
    return homePresenter
  }
}