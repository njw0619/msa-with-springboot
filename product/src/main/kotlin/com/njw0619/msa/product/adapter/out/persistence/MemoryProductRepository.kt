package com.njw0619.msa.product.adapter.out.persistence

import com.njw0619.msa.product.domain.Product
import org.springframework.stereotype.Component
import java.math.BigDecimal
import java.time.Instant

@Component
class MemoryProductRepository {
    companion object {
        val products = mutableListOf<ProductEntity>(
            ProductEntity(1L, "productA", BigDecimal(10_000), 100L, Instant.now(), Instant.now()),
            ProductEntity(2L, "productB", BigDecimal(5_000), 500L, Instant.now(), Instant.now())
        )
    }

    fun findById(productId: Long): Product? =
        products.findLast { it.id == productId }?.toDomain()

    fun save(product: Product): Long {
        val indexedValue = products.withIndex().find { it.value.id == product.id }
        if (indexedValue != null) {
            products[indexedValue.index] = ProductEntity(indexedValue.value.id, product.name, product.price, product.getQuantity(), indexedValue.value.createdAt, Instant.now())
        } else {
            val newUserId = if(products.isEmpty()) 1L else products.last().id + 1
            product.id = newUserId
            products.add(ProductEntity(newUserId, product.name, product.price, product.getQuantity(), Instant.now(), Instant.now()))
        }

        return product.id!!
    }
}