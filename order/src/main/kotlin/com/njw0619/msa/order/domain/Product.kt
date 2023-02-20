package com.njw0619.msa.order.domain

import java.math.BigDecimal

class Product(
    val id: Long,
    val name: String,
    val price: BigDecimal,
    private var quantity: Long
) {
    fun order(quantity: Long) {
        this.quantity -= quantity
    }

    fun getQuantity() = this.quantity
}