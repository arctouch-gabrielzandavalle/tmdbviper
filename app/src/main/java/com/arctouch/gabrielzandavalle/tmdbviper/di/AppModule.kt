package com.arctouch.gabrielzandavalle.tmdbviper.di

import com.arctouch.gabrielzandavalle.tmdbviper.service.TmdbApiInterface
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import rx.schedulers.Schedulers


/**
 * Created by gabrielzandavalle on 1/18/17.
 */

@Module
class AppModule(private val tmdbApplication: TmdbApplication) {

  @Provides @Singleton
  fun provideApplication() : TmdbApplication{
    return tmdbApplication;
  }

  @Provides @Singleton
  fun provideRetrofitBaseUrl() : String {
    return "https://api.themoviedb.org/3/"
  }

  @Provides @Singleton
  fun provideTmdbApi(retrofitBaseUrl: String) : TmdbApiInterface {

    val rxAdapter = RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io())

    val retrofit = Retrofit.Builder()
        .baseUrl(retrofitBaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(rxAdapter)
        .build();

    return retrofit.create(TmdbApiInterface::class.java)
  }
}
