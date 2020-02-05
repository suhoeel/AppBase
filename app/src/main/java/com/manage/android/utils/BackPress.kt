package com.manage.android.utils

import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

private var doubleBackToExitPressedOnce = false

fun AppCompatActivity.reAskToTerminate() {
    if (doubleBackToExitPressedOnce) {
        finish()
        return
    }
    doubleBackToExitPressedOnce = true
    Toast.makeText(this, "한 번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show()

    Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
}