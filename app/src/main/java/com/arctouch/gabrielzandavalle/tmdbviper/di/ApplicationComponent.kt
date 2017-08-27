package com.arctouch.gabrielzandavalle.tmdbviper.di

import com.arctouch.gabrielzandavalle.tmdbviper.adapter.MovieAdapter
import com.arctouch.gabrielzandavalle.tmdbviper.detail.DetailComponent
import com.arctouch.gabrielzandavalle.tmdbviper.detail.DetailModule
import com.arctouch.gabrielzandavalle.tmdbviper.home.HomeComponent
import com.arctouch.gabrielzandavalle.tmdbviper.home.HomeModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface ApplicationComponent {
    fun inject(viewHolder: MovieAdapter.ViewHolder)

    fun plus(module: HomeModule): HomeComponent
    fun plus(module: DetailModule): DetailComponent
}
