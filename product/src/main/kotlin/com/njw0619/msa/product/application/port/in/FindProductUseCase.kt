package com.njw0619.msa.product.application.port.`in`

import com.njw0619.msa.product.domain.Product

interface FindProductUseCase {
    fun findByProductId(productId: Long): Product
}