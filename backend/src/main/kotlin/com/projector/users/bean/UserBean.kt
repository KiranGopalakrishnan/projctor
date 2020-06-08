package com.projector.users.bean;

import com.projector.users.modal.Password
import com.projector.users.modal.User
import com.projector.users.modal.UserId

public data class UserBean(
        val id: String?,
        val username: String,
        val password: String
) {
    companion object{
        fun from(user: User):UserBean{
            return UserBean(
                    id = user.id?.value,
                    username = user.username,
                    password = user.password.toEncrypted()
            )
        }
    }

    fun toDomain(): User {
        return User(username = username,password = Password(password))
    }

}
