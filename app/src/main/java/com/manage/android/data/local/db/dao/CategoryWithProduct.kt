package com.manage.android.data.local.db.dao

import androidx.room.*

@Entity
data class CategoryWithProduct(
    @Embedded val category: Category,
    @Relation(
        parentColumn = "categoryId",
        entityColumn = "productId"
    )
    val product: List<Product>
)
