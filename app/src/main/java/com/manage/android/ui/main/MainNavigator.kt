package com.manage.android.ui.main

import android.content.Intent
import com.manage.android.ui.login.LoginActivity
import javax.inject.Inject


class MainNavigator @Inject constructor(private val activity: MainActivity) {

    fun toLoginActivity() {
        activity.startActivity(Intent(activity, LoginActivity::class.java))
    }

}