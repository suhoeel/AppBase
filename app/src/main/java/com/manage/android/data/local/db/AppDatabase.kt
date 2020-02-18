package com.manage.android.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.manage.android.data.local.db.dao.Category
import com.manage.android.data.local.db.dao.CategoryDao
import com.manage.android.data.local.db.dao.Product

@Database(entities = [Category::class, Product::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
}