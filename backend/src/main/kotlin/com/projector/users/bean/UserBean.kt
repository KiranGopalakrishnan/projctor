package com.projector.users.bean;

import com.projector.users.modal.User

data class UserBean(
        val id: String?,
        val email: String,
        val firstname: String?,
        val lastname: String?
) {
    companion object{
        fun from(user: User): UserBean {
            return UserBean(
                    id = user.id?.value,
                    email = user.email,
                    firstname = user.firstname,
                    lastname = user.lastname
            )
        }
    }
}
