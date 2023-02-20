package com.njw0619.msa.order.adapter.out.web

import com.njw0619.msa.order.application.port.out.ProductWebPort
import com.njw0619.msa.order.domain.Product
import com.njw0619.msa.product.adapter.`in`.web.dto.UpdateProductRequest
import org.springframework.stereotype.Component

@Component
class ProductWebAdapter(
    private val productRestClient: ProductRestClient
): ProductWebPort {
    override fun findById(productId: Long): Product {
        val response = productRestClient.findById(productId)
        return Product(response.id, response.name, response.price, response.quantity)
    }

    override fun update(product: Product) {
        productRestClient.update(product.id, UpdateProductRequest(product.name, product.price, product.getQuantity()))
    }
}