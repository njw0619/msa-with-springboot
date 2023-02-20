package com.njw0619.msa.order.adapter.`in`.web

import com.njw0619.msa.order.adapter.`in`.web.dto.OrderRequest
import com.njw0619.msa.order.adapter.`in`.web.dto.OrderResponse
import com.njw0619.msa.order.application.port.`in`.OrderUseCase
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/orders")
@RestController
class OrderController(
    private val orderUseCase: OrderUseCase
) {
    @PostMapping
    fun createOrder(@RequestBody orderRequest: OrderRequest): OrderResponse {
        val userId = SecurityContextHolder.getContext().authentication.principal as String
        val order = orderUseCase.order(userId.toLong(), orderRequest.productId, orderRequest.quantity)
        return OrderResponse(order.getId()!!, userId.toLong(), order.product.id, order.product.price, order.product.getQuantity())
    }
}