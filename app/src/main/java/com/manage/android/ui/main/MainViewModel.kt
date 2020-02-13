package com.manage.android.ui.main

import androidx.lifecycle.ViewModel
import com.manage.android.data.local.db.AppDbHelper
import com.manage.android.data.local.db.dao.Category
import javax.inject.Inject

class MainViewModel @Inject constructor(val appDbHelper: AppDbHelper) : ViewModel() {

    suspend fun addCategory(category: Category) {
        appDbHelper.insertCategory(category)
    }

}