package com.manage.android.data.local.db.dao

import androidx.room.*


@Dao
interface CategoryDao {

    @Query("SELECT * FROM categories")
    suspend fun getAllCategory(): List<Category>

    @Transaction
    @Query("SELECT * FROM categories")
    suspend fun getAllCategoryWithProduct(): List<CategoryWithProduct>

    @Insert
    suspend fun insert(category: Category)

    @Delete
    suspend fun delete(category: Category)


}