package com.projector.users.bean;

import com.projector.users.modal.User

data class UserBean(
        val id: String?,
        val username: String,
        val firstname: String?,
        val lastname: String?
) {
    companion object{
        fun from(user: User): UserBean {
            return UserBean(
                    id = user.id?.value,
                    username = user.username,
                    firstname = user.firstname,
                    lastname = user.lastname
            )
        }
    }
}
