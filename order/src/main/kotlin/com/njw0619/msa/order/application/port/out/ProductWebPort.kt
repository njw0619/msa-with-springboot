package com.njw0619.msa.order.application.port.out

import com.njw0619.msa.order.domain.Product

interface ProductWebPort {
    fun findById(productId: Long): Product
    fun update(product: Product)
}