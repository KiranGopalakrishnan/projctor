package com.projector.users.respository

import com.projector.common.mongo.EntityCollection
import com.projector.users.modal.Password
import com.projector.users.modal.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository {

    fun save(domain: User)

    fun findUser(username:String):User?

}