package com.arctouch.gabrielzandavalle.tmdbviper.di

import android.content.Context
import com.arctouch.gabrielzandavalle.tmdbviper.TmdbRepository
import com.arctouch.gabrielzandavalle.tmdbviper.home.HomeRouter
import com.arctouch.gabrielzandavalle.tmdbviper.service.TmdbApiInterface
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.schedulers.Schedulers
import javax.inject.Singleton

@Module
class AppModule(private val tmdbApplication: TmdbApplication) {

    @Provides
    @Singleton
    fun provideApplication() = tmdbApplication

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = tmdbApplication.applicationContext

    @Provides
    @Singleton
    fun provideRetrofitBaseUrl() = "https://api.themoviedb.org/3/"

    @Provides
    @Singleton
    fun provideTmdbRepository() = TmdbRepository()

    @Provides
    @Singleton
    fun provideTmdbApi(retrofitBaseUrl: String): TmdbApiInterface {
        val rxAdapter = RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io())

        val retrofit = Retrofit.Builder()
                .baseUrl(retrofitBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(rxAdapter)
                .build()

        return retrofit.create(TmdbApiInterface::class.java)
    }

    @Provides
    @Singleton
    fun provideHomeRouter(context: Context) = HomeRouter(context)
}
