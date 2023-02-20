package com.njw0619.msa.product.application.service

import com.njw0619.msa.product.application.port.`in`.FindProductUseCase
import com.njw0619.msa.product.application.port.`in`.UpdateProductUseCase
import com.njw0619.msa.product.application.port.out.ProductPersistencePort
import com.njw0619.msa.product.domain.Product
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productPersistencePort: ProductPersistencePort
): FindProductUseCase, UpdateProductUseCase {
    override fun findByProductId(productId: Long): Product {
        return productPersistencePort.findById(productId) ?: throw Exception("Cannot find product.")
    }

    override fun update(product: Product) {
        productPersistencePort.save(product)
    }
}