package com.njw0619.msa.gateway.config

import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder

@Configuration
class RouteConfig {
    @Bean
    fun customRouteLocator(builder: RouteLocatorBuilder): RouteLocator =
        builder.routes()
            .route {
                it.path("/users/**").or().path("/signup")
                    .filters { filter->
                        filter.addRequestHeader("Domain", "user")
                    }
                    .uri("lb://user")
            }
            .route {
                it.path("/products/**")
                    .filters { filter ->
                        filter.addRequestHeader("Domain", "product")
                    }
                    .uri("lb://product")
            }
            .route {
                it.path("/orders/**")
                    .filters { filter ->
                        filter.addRequestHeader("Domain", "order")
                    }
                    .uri("lb://order")
            }.build()
}