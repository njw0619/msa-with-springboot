package com.njw0619.msa.product.adapter.out.persistence

import com.njw0619.msa.product.domain.Product
import java.math.BigDecimal
import java.time.Instant

class ProductEntity(
    var id: Long,
    val name: String,
    val price: BigDecimal,
    val quantity: Long,
    val createdAt: Instant,
    val updatedAt: Instant
) {
    fun toDomain() = Product(id, name, price, quantity)
}