package com.njw0619.msa.order.application.port.`in`

import com.njw0619.msa.order.domain.Order

interface OrderUseCase {
    fun order(userId: Long, productId: Long, quantity: Long): Order
}