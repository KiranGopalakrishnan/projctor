package com.projector.users.modal

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.UUID;

inline class UserId(val value:String = UUID.randomUUID().toString())

data class User(
        val id: UserId? = UserId(),
        val email: String,
        val password: Password,
        val firstname: String?,
        val lastname: String?
)