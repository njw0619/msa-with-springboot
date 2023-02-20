package com.njw0619.msa.order.adapter.out.persistence

import com.njw0619.msa.order.application.port.out.OrderPersistencePort
import com.njw0619.msa.order.domain.Order
import org.springframework.stereotype.Component

@Component
class OrderPersistenceAdapter(
    private val memoryOrderRepository: MemoryOrderRepository
): OrderPersistencePort {
    override fun save(order: Order): Long {
        return memoryOrderRepository.save(order)
    }
}