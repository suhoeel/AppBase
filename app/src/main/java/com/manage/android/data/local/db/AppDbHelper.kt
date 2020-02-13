package com.manage.android.data.local.db

import com.manage.android.data.local.db.dao.Category
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDbHelper @Inject constructor(private val database: AppDatabase) : DbHelper {

    override suspend fun insertCategory(category: Category): Boolean {
        return try {
            database.categoryDao().insert(category)
            true
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun deleteCategory(category: Category): Boolean {
        return try {
            database.categoryDao().delete(category)
            true
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun getAllCategory(): List<Category> {
        return database.categoryDao().getAll()
    }



}