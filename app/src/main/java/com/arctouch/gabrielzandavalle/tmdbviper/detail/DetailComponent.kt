package com.arctouch.gabrielzandavalle.tmdbviper.detail

import com.arctouch.gabrielzandavalle.tmdbviper.di.ActivityScope
import dagger.Subcomponent

/**
 * Created by gabrielzandavalle on 3/8/17.
 */
@ActivityScope
@Subcomponent(modules = arrayOf(DetailModule::class))
interface DetailComponent {
  fun inject(detailActivity: DetailActivity)
}