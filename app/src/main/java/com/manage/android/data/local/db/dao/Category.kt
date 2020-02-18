package com.manage.android.data.local.db.dao

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class Category(
    @PrimaryKey(autoGenerate = true) val categoryId: Int = 0,
    val categoryName: String
)
