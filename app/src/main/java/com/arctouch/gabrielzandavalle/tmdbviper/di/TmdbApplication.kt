package com.arctouch.gabrielzandavalle.tmdbviper.di

import android.app.Application
import android.content.Context

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
