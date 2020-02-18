package com.manage.android.data.local.db

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.manage.android.data.local.db.dao.Category
import com.manage.android.data.local.db.dao.CategoryWithProduct
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDbHelper @Inject constructor(private val database: AppDatabase) : DbHelper {

    override suspend fun insertCategory(category: Category) {
        database.categoryDao().insert(category)
    }

    override suspend fun deleteCategory(category: Category) {
        database.categoryDao().delete(category)

    }

    override suspend fun getAllCategory(): List<Category> {
        return database.categoryDao().getAllCategory()
    }

    override suspend fun getAllCategoryWithProduct(): List<CategoryWithProduct> {
        return database.categoryDao().getAllCategoryWithProduct()
    }

}