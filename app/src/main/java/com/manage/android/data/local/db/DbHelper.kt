package com.manage.android.data.local.db

import com.manage.android.data.local.db.dao.Category

interface DbHelper {

    suspend fun getAllCategory(): List<Category>

    suspend fun insertCategory(category: Category): Boolean

    suspend fun deleteCategory(category: Category): Boolean

}