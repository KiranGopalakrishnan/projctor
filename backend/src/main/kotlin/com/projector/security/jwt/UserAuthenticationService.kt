package com.projector.security.jwt

import com.projector.users.respository.UserRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.transaction.annotation.Transactional

open class UserAuthenticationService(val userRepository: UserRepository): UserDetailsService {
    @Transactional(readOnly = true)
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findUser(username) ?: throw UsernameNotFoundException(username)
        return User(user.email, user.password.toString(), emptyList())
    }

    fun save(user: com.projector.users.modal.User) {
        userRepository.save(user)
    }
}