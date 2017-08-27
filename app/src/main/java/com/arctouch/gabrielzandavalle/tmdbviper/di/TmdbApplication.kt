package com.arctouch.gabrielzandavalle.tmdbviper.di

import android.app.Application
import android.content.Context

class TmdbApplication : Application() {

    companion object Factory {
        fun getComponent(context: Context): ApplicationComponent {
            return DaggerApplicationComponent
                    .builder()
                    .appModule(AppModule(context.applicationContext as TmdbApplication))
                    .build()
        }
    }
}
