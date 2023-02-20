package com.njw0619.msa.product.application.port.out

import com.njw0619.msa.product.domain.Product

interface ProductPersistencePort {
    fun findById(productId: Long): Product?
    fun save(product: Product): Long
}