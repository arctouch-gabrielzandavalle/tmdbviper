package com.arctouch.gabrielzandavalle.tmdbviper.home

import android.content.Context
import android.content.Intent
import com.arctouch.gabrielzandavalle.tmdbviper.detail.DetailActivity

class HomeRouter(private val context: Context) {

    fun navigateToDetail(id: String) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_SELECTED_MOVIE_ID, id)
        context.startActivity(intent)
    }
}
