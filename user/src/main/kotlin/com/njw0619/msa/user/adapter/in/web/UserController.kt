package com.njw0619.msa.user.adapter.`in`.web

import com.njw0619.msa.user.adapter.`in`.web.dto.FindUserResponse
import com.njw0619.msa.user.application.port.`in`.FindUserUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/users")
@RestController
class UserController(
    private val findUserUseCase: FindUserUseCase
) {
    @GetMapping("/{userId}")
    fun findUser(@PathVariable userId: Long): FindUserResponse {
        val user = findUserUseCase.findUser(userId)
        return FindUserResponse(user.id!!, user.name)
    }
}