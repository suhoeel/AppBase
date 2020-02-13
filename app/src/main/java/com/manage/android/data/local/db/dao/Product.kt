package com.manage.android.data.local.db.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    @PrimaryKey(autoGenerate = true) val productId: Int,
    @ColumnInfo(name = "name") val productName: String,
    @ColumnInfo(name = "quantity") val productQuantity: Int,
    @ColumnInfo(name = "price") val productPrice: String
)
