package com.manage.android.data.local.db.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Category(
    @PrimaryKey(autoGenerate = true) val categoryId: Int,
    @ColumnInfo(name = "name") val categoryName: String,
    @ColumnInfo(name = "product") val products: List<Product>
)
