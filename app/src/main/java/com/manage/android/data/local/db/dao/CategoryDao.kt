package com.manage.android.data.local.db.dao

import androidx.room.*

@Dao
interface CategoryDao {

    @Transaction
    @Query("SELECT * FROM category")
    suspend fun getAll(): List<Category>

    @Insert
    suspend fun insert(category: Category)

    @Delete
    suspend fun delete(category: Category)
}