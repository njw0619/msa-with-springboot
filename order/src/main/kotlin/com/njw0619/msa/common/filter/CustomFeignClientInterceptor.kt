package com.njw0619.msa.common.filter

import feign.RequestInterceptor
import feign.RequestTemplate
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class CustomFeignClientInterceptor: RequestInterceptor {
    override fun apply(template: RequestTemplate) {
        val userId = SecurityContextHolder.getContext().authentication.principal as String
        if (userId.isNotEmpty()) {
            template.header("User-Id", userId)
        }
    }

}