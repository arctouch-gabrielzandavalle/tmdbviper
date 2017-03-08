package com.arctouch.gabrielzandavalle.tmdbviper.di

import android.app.Application
import android.content.Context

/**
 * Created by gabrielzandavalle on 1/19/17.
 */
class TmdbApplication : Application() {

  var applicationComponent: ApplicationComponent = DaggerApplicationComponent
      .builder()
      .appModule(AppModule(this))
      .build()

  companion object Factory {
    fun get(context: Context): TmdbApplication {
      return context.applicationContext as TmdbApplication
    }
  }
}