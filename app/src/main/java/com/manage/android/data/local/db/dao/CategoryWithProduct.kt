package com.manage.android.data.local.db.dao

import androidx.room.Embedded
import androidx.room.Relation

data class CategoryWithProduct(
    @Embedded val category: Category,
    @Relation(
        parentColumn = "categoryId",
        entityColumn = "productId",
        entity = Product::class
    )
    val productList: List<Product>
)