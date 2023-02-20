package com.njw0619.msa.user.adapter.out.persistence

import com.njw0619.msa.user.application.port.out.UserPersistencePort
import com.njw0619.msa.user.domain.User
import org.springframework.stereotype.Component

@Component
class UserPersistenceAdapter(
    private val memoryUserRepository: MemoryUserRepository
): UserPersistencePort{
    override fun create(user: User): Long = memoryUserRepository.save(user)

    override fun findById(userId: Long): User? = memoryUserRepository.findById(userId)
}