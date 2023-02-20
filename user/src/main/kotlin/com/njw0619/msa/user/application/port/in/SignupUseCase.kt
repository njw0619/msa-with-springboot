package com.njw0619.msa.user.application.port.`in`

import com.njw0619.msa.user.domain.User

interface SignupUseCase {
    fun signup(user: User): Long
}