package com.manage.android.utils

import android.util.Patterns

fun String.isEmail(): Boolean = Patterns.EMAIL_ADDRESS.matcher(this).matches()
