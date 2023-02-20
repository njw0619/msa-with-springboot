package com.njw0619.msa.order.application.port.out

import com.njw0619.msa.order.domain.Order

interface OrderPersistencePort {
    fun save(order: Order): Long
}