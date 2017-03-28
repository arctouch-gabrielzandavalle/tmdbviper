package com.arctouch.gabrielzandavalle.tmdbviper

import android.app.Activity
import android.content.Intent
import com.arctouch.gabrielzandavalle.tmdbviper.detail.DetailActivity

class Router {

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
