package com.projector.users.bean

import com.projector.users.modal.Password
import com.projector.users.modal.User
import com.projector.users.modal.UserId


data class UserPostBean(
        val username: String,
        val password: String,
        val firstname: String?,
        val lastname: String?
) {


    fun toDomain(): User {
        return User(
                username =  username,
                password = Password(password),
                firstname = firstname,
                lastname = lastname
        )
    }
}