package com.njw0619.msa.common.filter

import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.GenericFilterBean

@Component
class CustomAuthenticationFilter: GenericFilterBean() {
    override fun doFilter(servletRequest: ServletRequest, servletResponse: ServletResponse, chain: FilterChain) {
        val request = servletRequest as HttpServletRequest
        val response = servletResponse as HttpServletResponse

        val userId = request.getHeader("User-Id")

        if (userId!= null && userId.isNotEmpty()) {
            SecurityContextHolder.getContext().authentication = UsernamePasswordAuthenticationToken(userId, null, null)
        }

        chain.doFilter(request, response)
    }
}