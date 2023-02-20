package com.njw0619.msa.user.adapter.out.persistence

import com.njw0619.msa.user.domain.User
import java.time.Instant

class UserEntity(
    val id: Long,
    val name: String,
    val createdAt: Instant
) {
    fun toDomain(): User = User(id, name)
}