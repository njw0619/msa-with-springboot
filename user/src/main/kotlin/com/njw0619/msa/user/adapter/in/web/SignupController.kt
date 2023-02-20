package com.njw0619.msa.user.adapter.`in`.web

import com.njw0619.msa.user.adapter.`in`.web.dto.SignupRequest
import com.njw0619.msa.user.application.port.`in`.SignupUseCase
import com.njw0619.msa.user.domain.User
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/signup")
@RestController
class SignupController(
    private val signupUseCase: SignupUseCase
) {
    @PostMapping
    fun signup(@RequestBody signupRequest: SignupRequest): Long {
        return signupUseCase.signup(User(name = signupRequest.name))
    }
}