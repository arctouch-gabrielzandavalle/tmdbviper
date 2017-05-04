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

  val movies = listOf<Movie>(Movie(title = "Titanic"), Movie(title = "Gladiator"))

  lateinit var homePresenter: HomePresenter

  @Mock
  lateinit var homePresenterOutput: HomeContracts.HomePresenterOutput
  @Mock
  lateinit var homeInteractorInput: HomeContracts.HomeInteractorInput

  @Before
  fun setUp() {
    MockitoAnnotations.initMocks(this)
    homePresenter = HomePresenter(homeInteractorInput)
    homePresenter.setPresenterOutput(homePresenterOutput)

    given(homeInteractorInput.loadMovies()).will { homePresenter.moviesLoaded(movies) }
  }

  @Test
  fun shouldLoadMoviesWhenViewIsLoaded() {
    homePresenter.viewLoaded()
    verify(homeInteractorInput).loadMovies()
  }

  @Test
  fun shouldShowMoviesWhenMoviesAreLoaded() {
    homePresenter.moviesLoaded(movies)
    verify(homePresenterOutput).showMovies(movies)
  }
}
