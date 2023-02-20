package com.njw0619.msa.order.application.service

import com.njw0619.msa.order.application.port.`in`.OrderUseCase
import com.njw0619.msa.order.application.port.out.OrderPersistencePort
import com.njw0619.msa.order.application.port.out.ProductWebPort
import com.njw0619.msa.order.domain.Order
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val orderPersistencePort: OrderPersistencePort,
    private val productWebPort: ProductWebPort
): OrderUseCase {
    override fun order(userId: Long, productId: Long, quantity: Long): Order {
        val product = productWebPort.findById(productId)

        val order = Order(userId, product)
        val newOrderId = orderPersistencePort.save(order)

        product.order(quantity)
        productWebPort.update(product)

        order.setId(newOrderId)
        return order
    }
}