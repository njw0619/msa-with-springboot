package com.njw0619.msa.order.domain

import java.math.BigDecimal

class Order(
    val userId: Long,
    val product: Product
) {
    private var id: Long? = null

    fun setId(id: Long) {
        this.id = id
    }

    fun getId() = this.id
}