package com.arctouch.gabrielzandavalle.tmdbviper

import com.arctouch.gabrielzandavalle.tmdbviper.home.HomeContracts
import com.arctouch.gabrielzandavalle.tmdbviper.home.HomeInteractor
import com.arctouch.gabrielzandavalle.tmdbviper.home.HomePresenter
import com.arctouch.gabrielzandavalle.tmdbviper.model.Movie
import com.arctouch.gabrielzandavalle.tmdbviper.model.MovieListDisplayModel
import com.arctouch.gabrielzandavalle.tmdbviper.service.TmdbApiInterface
import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito.*
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import rx.Observable
import rx.schedulers.Schedulers

/**
 * Created by gabrielzandavalle on 4/5/17.
 */
class TestHomePresenter {

  val movies = listOf<Movie>()

  lateinit var movieListDisplayModel: MovieListDisplayModel

  lateinit var homePresenter: HomePresenter

  lateinit var homeInteractor: HomeInteractor

  @Mock
  lateinit var homePresenterOutput: HomeContracts.HomePresenterOutput

  @Mock
  lateinit var tmdbApi: TmdbApiInterface

  @Before
  fun setUp() {
    MockitoAnnotations.initMocks(this)
    homeInteractor = HomeInteractor(tmdbApi, Schedulers.immediate(), Schedulers.immediate())
    homePresenter = HomePresenter(homeInteractor)
    homeInteractor.setInteractorOutput(homePresenter)
    homePresenter.setPresenterOutput(homePresenterOutput)

    movieListDisplayModel = MovieListDisplayModel(id = "1", items = movies)
    given(tmdbApi.getList(anyString(), anyString()))
        .willReturn(Observable.just(movieListDisplayModel))
  }

  @Test
  fun testViewLoaded() {
    homePresenter.viewLoaded()
    Mockito.verify(homePresenterOutput).showMovies(movies)
  }
}
