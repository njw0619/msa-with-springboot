package com.njw0619.msa.product.adapter.out.persistence

import com.njw0619.msa.product.application.port.out.ProductPersistencePort
import com.njw0619.msa.product.domain.Product
import org.springframework.stereotype.Component
import java.math.BigDecimal
import java.time.Instant

@Component
class ProductPersistenceAdapter(
    private val memoryProductRepository: MemoryProductRepository
): ProductPersistencePort {

    override fun findById(productId: Long): Product? =
        memoryProductRepository.findById(productId)

    override fun save(product: Product): Long =
        memoryProductRepository.save(product)
}