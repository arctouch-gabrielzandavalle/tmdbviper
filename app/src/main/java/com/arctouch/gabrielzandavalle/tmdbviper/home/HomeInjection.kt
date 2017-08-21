package com.arctouch.gabrielzandavalle.tmdbviper.home

import android.app.Activity
import com.arctouch.gabrielzandavalle.tmdbviper.di.ActivityScope
import com.arctouch.gabrielzandavalle.tmdbviper.service.TmdbApiInterface
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = arrayOf(HomeModule::class))
interface HomeComponent {
    fun inject(homeActivity: HomeActivity)
}

@Module
class HomeModule(private val homeInteractorOutput: HomeContracts.HomePresenterOutput) {

    @Provides @ActivityScope
    fun provideHomePresenterInput(homeInteractorInput: HomeContracts.HomeInteractorInput): HomeContracts.HomePresenterInput {
        val homePresenter: HomePresenter = HomePresenter(homeInteractorOutput, homeInteractorInput)
        homeInteractorInput.setInteractorOutput(homePresenter)
        return homePresenter
    }

    @Provides @ActivityScope
    fun provideHomeInteractor(tmdbApiInterface: TmdbApiInterface): HomeContracts.HomeInteractorInput {
        return HomeInteractor(tmdbApiInterface)
    }
}
