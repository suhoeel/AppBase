package com.manage.android.data.local.db

import com.manage.android.data.local.db.dao.Category
import com.manage.android.data.local.db.dao.CategoryWithProduct

interface DbHelper {

    suspend fun insertCategory(category: Category)

    suspend fun deleteCategory(category: Category)

    suspend fun getAllCategory(): List<Category>

    suspend fun getAllCategoryWithProduct(): List<CategoryWithProduct>


}