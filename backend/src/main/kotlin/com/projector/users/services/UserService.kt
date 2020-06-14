package com.projector.users.services

import com.projector.common.http.Response
import com.projector.users.modal.Password
import com.projector.users.modal.User
import org.springframework.stereotype.Service

@Service
interface UserService {

    fun getAllUsers(): Response<List<User>>

    fun addUser(user: User): Response<User>

    fun authenticateUser(username:String,password:String): Response<User>

}