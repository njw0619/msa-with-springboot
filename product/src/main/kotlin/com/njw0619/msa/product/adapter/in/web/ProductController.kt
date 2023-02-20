package com.njw0619.msa.product.adapter.`in`.web

import com.njw0619.msa.product.adapter.`in`.web.dto.FindProductResponse
import com.njw0619.msa.product.adapter.`in`.web.dto.UpdateProductRequest

import com.njw0619.msa.product.application.port.`in`.FindProductUseCase
import com.njw0619.msa.product.application.port.`in`.UpdateProductUseCase
import com.njw0619.msa.product.domain.Product
import org.springframework.web.bind.annotation.*


@RequestMapping("/products")
@RestController
class ProductController(
    private val findProductUseCase: FindProductUseCase,
    private val updateProductUseCase: UpdateProductUseCase
) {
    @GetMapping("/{productId}")
    fun findById(@PathVariable("productId") productId: Long): FindProductResponse {
        val product = findProductUseCase.findByProductId(productId)
        return FindProductResponse(product.id!!, product.name, product.price, product.getQuantity())
    }

    @PutMapping("/{productId}")
    fun update(@PathVariable("productId") productId: Long, @RequestBody updateProductRequest: UpdateProductRequest) {
        updateProductUseCase.update(Product(productId, updateProductRequest.name, updateProductRequest.price, updateProductRequest.quantity))
    }
}