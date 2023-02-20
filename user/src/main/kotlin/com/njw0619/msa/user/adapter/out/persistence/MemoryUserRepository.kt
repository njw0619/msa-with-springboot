package com.njw0619.msa.user.adapter.out.persistence

import com.njw0619.msa.user.domain.User
import org.springframework.stereotype.Repository
import java.time.Instant

@Repository
class MemoryUserRepository {
    companion object {
        val users = mutableListOf(
            UserEntity(1L, "userA", Instant.now()),
            UserEntity(2L, "userB", Instant.now())
        )
    }

    fun findById(userId: Long): User? =
        users.findLast { it.id == userId }?.toDomain()

    fun save(user: User): Long {
        val indexedValue = users.withIndex().find { it.value.id == user.id }
        if (indexedValue != null) {
            users[indexedValue.index] = UserEntity(indexedValue.value.id, user.name, indexedValue.value.createdAt)
        } else {
            val newUserId = if(users.isEmpty()) 1L else users.last().id + 1
            user.id = newUserId
            users.add(UserEntity(newUserId, user.name, Instant.now()))
        }

        return user.id!!
    }
}