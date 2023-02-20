package com.njw0619.msa.order.adapter.out.web

import com.njw0619.msa.product.adapter.`in`.web.dto.FindProductResponse
import com.njw0619.msa.product.adapter.`in`.web.dto.UpdateProductRequest
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.*

@FeignClient(name = "product")
interface ProductRestClient {
    @GetMapping("/products/{productId}")
    fun findById(@PathVariable("productId") productId: Long): FindProductResponse

    @PutMapping("/products/{productId}")
    fun update(@PathVariable("productId") productId: Long, @RequestBody updateProductRequest: UpdateProductRequest)
}