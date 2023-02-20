package com.njw0619.msa.order.adapter.out.persistence

import com.njw0619.msa.order.domain.Order
import org.springframework.stereotype.Component

@Component
class MemoryOrderRepository {
    companion object {
        val orders = mutableListOf<Order>()
    }

    fun save(order: Order): Long {
        val newOrderId = if(orders.isEmpty()) 1L else orders.last().getId()!! + 1L
        order.setId(newOrderId)
        orders.add(order)
        return newOrderId
    }
}