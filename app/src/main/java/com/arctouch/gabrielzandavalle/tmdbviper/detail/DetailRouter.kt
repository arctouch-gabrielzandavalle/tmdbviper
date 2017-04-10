package com.arctouch.gabrielzandavalle.tmdbviper.detail

import android.app.Activity
import android.content.Intent

class DetailRouter {

  companion object Factory {

    private var mActivity: Activity? = null

    fun setActivity(activity: Activity) {
      mActivity = activity
    }

    fun createDetailModule (id: String) {
      val intent = Intent(mActivity, DetailActivity::class.java)
      intent.putExtra("selectedMovie", id)
      mActivity?.startActivity(intent)
    }
  }
}
