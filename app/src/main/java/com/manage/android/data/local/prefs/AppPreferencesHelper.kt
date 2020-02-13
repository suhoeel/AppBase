package com.manage.android.data.local.prefs

import android.content.Context

class AppPreferencesHelper(context: Context, prefFileName: String) : PreferencesHelper{

    companion object {
        const val PREF_KEY_CURRENT_CATEGORY = "PREF_KEY_CURRENT_CATEGORY"
    }


}