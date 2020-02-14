package com.manage.android.data.local.db.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    @PrimaryKey(autoGenerate = true) val productId: Int,
    val productName: String,
    val productQuantity: Int,
    val productPrice: String
)
