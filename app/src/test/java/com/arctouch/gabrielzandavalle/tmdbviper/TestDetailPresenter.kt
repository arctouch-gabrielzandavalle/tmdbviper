package com.arctouch.gabrielzandavalle.tmdbviper

import com.arctouch.gabrielzandavalle.tmdbviper.detail.DetailContracts
import com.arctouch.gabrielzandavalle.tmdbviper.detail.DetailInteractor
import com.arctouch.gabrielzandavalle.tmdbviper.detail.DetailPresenter
import com.arctouch.gabrielzandavalle.tmdbviper.model.Movie
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
 * Created by gabrielzandavalle on 4/6/17.
 */
class TestDetailPresenter {

  lateinit var selectedMovie: Movie

  lateinit var detailInteractor: DetailInteractor

  lateinit var detailPresenter: DetailPresenter

  @Mock
  lateinit var detailPresenterOutput: DetailContracts.DetailPresenterOutput

  @Mock
  lateinit var tmdbApi: TmdbApiInterface

  lateinit var tmdbRepository: TmdbRepository

  @Before
  fun setUp() {
    MockitoAnnotations.initMocks(this)
    tmdbRepository = TmdbRepository()
    selectedMovie = Movie("1", "", "", "")
    detailInteractor = DetailInteractor(tmdbRepository, tmdbApi,  Schedulers.immediate(), Schedulers
        .immediate())
    detailPresenter = DetailPresenter(detailInteractor)
    detailInteractor.setInteractorOutput(detailPresenter)
    detailPresenter.setPresenterOutput(detailPresenterOutput)

    given(tmdbApi.getMovie(anyString(), anyString())).willReturn(Observable.just(selectedMovie))
  }

  @Test
  fun testViewLoaded() {
    detailPresenter.viewLoaded("1")
    Mockito.verify(detailPresenterOutput).showMovieDetail(selectedMovie)
  }

  @Test
  fun testAddMovieToWatchList() {
    detailPresenter.viewLoaded("1")
    detailPresenter.addToWatchList()
    Mockito.verify(detailPresenterOutput).showMessageMovieAddedToWatchList(selectedMovie)
  }
}