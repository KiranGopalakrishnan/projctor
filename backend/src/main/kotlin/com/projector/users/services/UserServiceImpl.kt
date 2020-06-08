package com.projector.users.services

import com.projector.users.modal.Password
import com.projector.users.modal.User
import com.projector.users.respository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl:UserService {

    @Autowired
    lateinit var userRepository: UserRepository;

    override fun getAllUsers():List<User>{
        val user = User(username = "Kiran",password = Password("kiran1994"))
        userRepository.save(user)
        return listOf(user)
    }

    override fun authenticateUser(username:String,password: String): User? {
        val user = userRepository.findUser(username = username) ?: return null
        return if(user.password.matches(password)) {
            user
        }else{
            null
        }
    }

}