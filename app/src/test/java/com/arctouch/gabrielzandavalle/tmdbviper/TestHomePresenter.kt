package com.arctouch.gabrielzandavalle.tmdbviper

import com.arctouch.gabrielzandavalle.tmdbviper.home.HomeContracts
import com.arctouch.gabrielzandavalle.tmdbviper.home.HomePresenter
import com.arctouch.gabrielzandavalle.tmdbviper.model.Movie
import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.verify
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class TestHomePresenter {

    private val movies = listOf(Movie(title = "Titanic"), Movie(title = "Gladiator"))

    private lateinit var homePresenter: HomePresenter

    @Mock
    lateinit var homePresenterOutput: HomeContracts.HomePresenterOutput
    @Mock
    lateinit var homeInteractorInput: HomeContracts.HomeInteractorInput

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        homePresenter = HomePresenter(homePresenterOutput, homeInteractorInput)

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
