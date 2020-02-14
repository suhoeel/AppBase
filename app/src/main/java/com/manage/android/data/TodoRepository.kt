package com.manage.android.data

import com.manage.android.data.local.db.AppDbHelper
import com.manage.android.data.local.db.dao.Category
import com.manage.android.data.local.db.dao.CategoryWithProduct
import javax.inject.Inject

class TodoRepository @Inject constructor(private val appDbHelper: AppDbHelper) {

    suspend fun insertCategory(category: Category) {
        appDbHelper.insertCategory(category)
    }

    suspend fun deleteCategory(category: Category) {
        appDbHelper.deleteCategory(category)
    }

    suspend fun getAllCategory(): List<Category> {
        return appDbHelper.getAllCategory()
    }

    suspend fun getAllCategoryWithProduct(): List<CategoryWithProduct> {
        return appDbHelper.getAllCategoryWithProduct()
    }
}