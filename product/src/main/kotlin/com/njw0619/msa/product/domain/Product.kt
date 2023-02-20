package com.njw0619.msa.product.domain

import java.math.BigDecimal
import java.time.Instant

class Product(
    var id: Long?,
    val name: String,
    val price: BigDecimal,
    private var quantity: Long
) {
    fun getQuantity(): Long = this.quantity
}