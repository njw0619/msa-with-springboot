package com.njw0619.msa.user.application.service

import com.njw0619.msa.user.application.port.`in`.FindUserUseCase
import com.njw0619.msa.user.application.port.`in`.SignupUseCase
import com.njw0619.msa.user.application.port.out.UserPersistencePort
import com.njw0619.msa.user.domain.User
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userPersistencePort: UserPersistencePort
): FindUserUseCase, SignupUseCase {
    override fun findUser(userId: Long): User {
        return userPersistencePort.findById(userId) ?: throw Exception("Cannot find user. id=$userId")
    }

    override fun signup(user: User): Long {
        return userPersistencePort.create(user)
    }

}