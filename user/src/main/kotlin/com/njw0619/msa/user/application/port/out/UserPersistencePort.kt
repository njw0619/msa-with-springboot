package com.njw0619.msa.user.application.port.out

import com.njw0619.msa.user.domain.User

interface UserPersistencePort {
    fun create(user: User): Long
    fun findById(userId: Long): User?
}