package com.njw0619.msa.product.adapter.`in`.web.dto

import java.math.BigDecimal

class UpdateProductRequest(
    val name: String,
    val price: BigDecimal,
    val quantity: Long
)