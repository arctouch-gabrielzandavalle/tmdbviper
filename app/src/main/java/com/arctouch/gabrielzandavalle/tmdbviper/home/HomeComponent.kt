package com.arctouch.gabrielzandavalle.tmdbviper.home

import com.arctouch.gabrielzandavalle.tmdbviper.di.ActivityScope
import dagger.Subcomponent

/**
 * Created by gabrielzandavalle on 3/8/17.
 */
@ActivityScope
@Subcomponent(modules = arrayOf(HomeModule::class))
interface HomeComponent {
  fun inject(homeActivity: HomeActivity)
}
