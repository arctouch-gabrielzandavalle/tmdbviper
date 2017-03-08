package com.arctouch.gabrielzandavalle.tmdbviper.di

import com.arctouch.gabrielzandavalle.tmdbviper.home.HomeComponent
import com.arctouch.gabrielzandavalle.tmdbviper.home.HomeModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by gabrielzandavalle on 1/19/17.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface ApplicationComponent {
  fun plus(module: HomeModule): HomeComponent
}