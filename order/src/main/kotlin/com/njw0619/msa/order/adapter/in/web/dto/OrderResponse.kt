package com.njw0619.msa.order.adapter.`in`.web.dto

import java.math.BigDecimal

class OrderResponse(
    val id: Long,
    val userId: Long,
    val productId: Long,
    val price: BigDecimal,
    val quantity: Long
) {
}