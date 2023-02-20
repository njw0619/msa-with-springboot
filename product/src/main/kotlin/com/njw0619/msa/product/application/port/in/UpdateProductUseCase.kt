package com.njw0619.msa.product.application.port.`in`

import com.njw0619.msa.product.domain.Product

interface UpdateProductUseCase {
    fun update(product: Product)
}