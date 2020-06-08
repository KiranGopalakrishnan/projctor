package com.projector.users.services

import com.projector.users.modal.Password
import com.projector.users.modal.User
import org.springframework.stereotype.Service

@Service
interface UserService {
    fun getAllUsers(): List<User>

    fun authenticateUser(username:String,password:String): User?
}